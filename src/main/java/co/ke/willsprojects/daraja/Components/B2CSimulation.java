package co.ke.willsprojects.daraja.Components;

import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import co.ke.willsprojects.daraja.JsonSchemas.B2CSimulationRequest;
import co.ke.willsprojects.daraja.JsonSchemas.B2CSimulationResponse;
import co.ke.willsprojects.daraja.Utils.CONSTANTS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@Slf4j
public class B2CSimulation {
    @Autowired
    private RestTemplate template;

    @Autowired
    private MpesaAuthentication authentication;

    @Value("${app.consumer.key}")
    private String consumerKey;
    @Value("${app.consumer.secret}")
    private String consumerSecret;

    public B2CSimulationResponse simulate(B2CSimulationRequest request) {
        AuthorizationResponse response = authentication.authenticate();
        if (!Objects.isNull(response)) {
            log.error("M-PESA Authorization could not be done");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + response.getAccessToken());
        HttpEntity<B2CSimulationRequest> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<B2CSimulationResponse> responseEntity = template.exchange(CONSTANTS.b2cSimulationUrl, HttpMethod.POST, requestEntity, B2CSimulationResponse.class);
        return responseEntity.getBody();
    }
}
