package co.ke.willsprojects.daraja.Resources;

import co.ke.willsprojects.daraja.Components.B2CSimulation;
import co.ke.willsprojects.daraja.Components.MpesaAuthentication;
import co.ke.willsprojects.daraja.JsonSchemas.AuthorizationResponse;
import co.ke.willsprojects.daraja.JsonSchemas.C2BSimulationRequest;
import co.ke.willsprojects.daraja.JsonSchemas.C2BSimulationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("mpesa")
@RestController
@CrossOrigin
public class ApiEndpoints {
    @Autowired
    private MpesaAuthentication authentication;

    @Autowired
    private B2CSimulation simulation;

    @Autowired
    private RestTemplate template;

    @GetMapping("authorize")
    public ResponseEntity<AuthorizationResponse> authorize() {
        return ResponseEntity.ok().body(authentication.authenticate());
    }

    @PostMapping("b2cSimulation")
    public ResponseEntity<C2BSimulationResponse> simulate(@RequestBody C2BSimulationRequest request) {
        return ResponseEntity.ok().body(simulation.simulate(request));
    }


}
