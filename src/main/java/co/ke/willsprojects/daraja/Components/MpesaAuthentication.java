package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Slf4j
public class MpesaAuthentication {
    @Autowired
    private RestTemplate template;

    @Value("${mpesa.app.consumer.key}")
    private String consumerKey;
    @Value("${mpesa.app.consumer.secret}")
    private String consumerSecret;

    public AuthorizationResponse authenticate() {
        String appKeySecret = consumerKey + ":" + consumerSecret;
        byte[] bytes = appKeySecret.getBytes(StandardCharsets.ISO_8859_1);
        String encoded = Base64.getEncoder().encodeToString(bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(consumerSecret, consumerKey);
        headers.set("Authorization", "Basic " + encoded);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AuthorizationResponse> response = template.exchange(CONSTANTS.authenticationUrl, HttpMethod.GET, requestEntity, AuthorizationResponse.class);
        return response.getBody();
    }
}
