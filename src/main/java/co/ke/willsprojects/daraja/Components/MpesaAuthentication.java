package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MpesaAuthentication {
    @Autowired
    private RestTemplate template;

    public AuthorizationResponse authenticate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(CONSTANTS.consumerSecret, CONSTANTS.consumerKey);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AuthorizationResponse> response = template.exchange(CONSTANTS.authenticationUrl, HttpMethod.GET, requestEntity, AuthorizationResponse.class);
        return response.getBody();
    }
}
