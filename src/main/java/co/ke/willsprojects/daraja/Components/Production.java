package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.*;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import co.ke.willsprojects.daraja.Utils.Certificate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@Slf4j
public class Production {
    @Autowired
    private RestTemplate template;

    @Autowired
    private MpesaAuthentication authentication;

    @Autowired
    private PasswordEncrypt passwordEncrypt;

    /**
     * Buy Goods and Services Paybill
     **/
    public C2BSimulationResponse c2bSimulation(C2BSimulationRequest request) {
        AuthorizationResponse response = authentication.authenticate();
        if (Objects.isNull(response)) {
            log.error("M-PESA Authorization could not be done");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + response.getAccessToken());
        HttpEntity<C2BSimulationRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<C2BSimulationResponse> responseEntity = template.exchange(CONSTANTS.c2bSimulationUrl, HttpMethod.POST, requestEntity, C2BSimulationResponse.class);
        return responseEntity.getBody();
    }

    /**
     * Bulk Disbursement Paybill
     */
    public B2CResponse b2cSimulation(B2CRequest request) {
        AuthorizationResponse response = authentication.authenticate();
        if (Objects.isNull(response)) {
            log.error("M-PESA Authorization could not be done");
        }
        request.setCommandID("BusinessPayment");
        request.setOccasion("Customer Credit");
        request.setSecurityCredential(passwordEncrypt.generateSecurityCredentials(Certificate.simulationCertificate, CONSTANTS.B2C_TEST_INITIATOR_PASSWD));
        log.info("Security Credential are {}", request.getSecurityCredential());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + response.getAccessToken());
        HttpEntity<B2CRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<B2CResponse> responseEntity = template.exchange(CONSTANTS.b2cSimulationUrl, HttpMethod.POST, requestEntity, B2CResponse.class);
        return responseEntity.getBody();
    }
}
