package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import co.ke.willsprojects.daraja.JsonSchemas.C2BRegisterUrlRequest;
import co.ke.willsprojects.daraja.JsonSchemas.C2BRegistrationResponse;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@Slf4j
public class C2BUrlRegistration {
    @Autowired
    private RestTemplate template;

    @Autowired
    private MpesaAuthentication authentication;

    public C2BRegistrationResponse registerUrlResponse(C2BRegisterUrlRequest request) {
        AuthorizationResponse response = authentication.authenticate();
        if (Objects.isNull(response)) {
            log.error("M-PESA Authorization could not be done");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + response.getAccessToken());
        HttpEntity<C2BRegisterUrlRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<C2BRegistrationResponse> responseEntity = template.exchange(CONSTANTS.c2bUrlRegistrationUrl, HttpMethod.POST, requestEntity, C2BRegistrationResponse.class);
        return responseEntity.getBody();
    }
}
