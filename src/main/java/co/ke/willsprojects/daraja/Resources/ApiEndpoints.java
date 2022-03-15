package co.ke.willsprojects.daraja.Resources;

import co.ke.willsprojects.daraja.Components.MpesaAuthentication;
import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("mpesa")
@RestController
@CrossOrigin
public class ApiEndpoints {
    @Autowired
    private MpesaAuthentication authentication;

    @Autowired
    private RestTemplate template;

    @GetMapping("authorize")
    public ResponseEntity<AuthorizationResponse> authorize() {
        return ResponseEntity.ok().body(authentication.authenticate());
    }


}
