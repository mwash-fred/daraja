package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.*;
import co.ke.willsprojects.daraja.Models.MpesaConfirmations.MpesaConfirmation;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * On confirmation or rejection the notification is sent to the core System
 * @Author Wilfred Mwangi
 * */

@Component @Slf4j
public class PushNotification {
    @Autowired
    private RestTemplate template;

    @Value("{fortunecredit.url.sit}")
    private String url;

    @Value("{integration.mpesa.username}")
    public String username;

    @Value("{integration.mpesa.password}")
    public String password;

    public void confirmation(ConfirmationRequest request){
        try{
            MpesaConfirmation confirmation = new MpesaConfirmation(null, request.getFirstName().toUpperCase()+" "+request.getLastName().toUpperCase(),
                    request.getMSISDN(), request.getTransAmount(), request.getTransTime(), request.getBusinessShortCode(), request.getTransID(),
                    request.getTransactionType(), null, null, null);
            //Login First
            LoginRequest loginRequest = new LoginRequest(CONSTANTS.username, CONSTANTS.password);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LoginRequest> loginRequestEntity = new HttpEntity<>(loginRequest, headers);
            ResponseEntity<LoginResponse> loginResponseEntity = template.exchange(CONSTANTS.connectUrl+"auth/signin", HttpMethod.POST, loginRequestEntity, LoginResponse.class);
            //Posting to System After Authentication
            MpesaRepayment repayment = new MpesaRepayment(request.getMSISDN(), request.getTransAmount(), request.getFirstName().toUpperCase() + " "+
                    request.getLastName().toUpperCase(), request.getTransID(), request.getBusinessShortCode(), request.getBillRefNumber());
            log.info("Request {}", repayment);
            headers.set("Authorization", "Bearer " + Objects.requireNonNull(loginResponseEntity.getBody()).getAccessToken());
            HttpEntity<MpesaRepayment> mpesaRepaymentHttpEntity = new HttpEntity<>(repayment , headers);
            ResponseEntity<CoreResponse> coreResponseEntity= template.exchange(CONSTANTS.connectUrl+"transactions/mpesa", HttpMethod.POST, mpesaRepaymentHttpEntity, CoreResponse.class);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
