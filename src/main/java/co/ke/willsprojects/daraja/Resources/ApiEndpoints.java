package co.ke.willsprojects.daraja.Resources;

import co.ke.willsprojects.daraja.Components.*;
import co.ke.willsprojects.daraja.JsonSchemas.*;
import co.ke.willsprojects.daraja.Models.MpesaConfirmations.MpesaConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("mobile")
@RestController
@CrossOrigin
public class ApiEndpoints {
    @Autowired
    private MpesaAuthentication authentication;

    @Autowired
    private Production simulation;

    @Autowired
    private MpesaConfirmationRepository repository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private C2BUrlRegistration registration;

    @Autowired
    private PushNotification notification;

    @GetMapping("authorize")
    public ResponseEntity<AuthorizationResponse> authorize() {
        return ResponseEntity.ok().body(authentication.authenticate());
    }

    @PostMapping("c2bSimulation")
    public ResponseEntity<C2BSimulationResponse> c2bSimulation(@RequestBody C2BSimulationRequest request) {
        return ResponseEntity.ok().body(simulation.c2bSimulation(request));
    }

    @PostMapping("b2cSimulation")
    public ResponseEntity<?> b2cSimulation(@RequestBody B2CRequest request) {
        return ResponseEntity.ok().body(simulation.b2cSimulation(request));
    }

    @PostMapping("register/confirmationUrl")
    public ResponseEntity<C2BRegistrationResponse> registerCofirmationUrl(@RequestBody C2BRegisterUrlRequest request) {
        AuthorizationResponse response = authorize().getBody();
        return ResponseEntity.ok().body(registration.registerUrlResponse(request, response));
    }

    @PostMapping("confirm/payment")
    public ResponseEntity<ConfirmationRequest> confirm(@RequestBody ConfirmationRequest request) {
        notification.confirmation(request);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping("validate/payment")
    public ResponseEntity<C2BValidationResponse> validate(@RequestBody C2BValidationRequest request) {
        C2BValidationResponse response = new C2BValidationResponse("Accepted", 0);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("disbursement/confirm-payment")
    public ResponseEntity<?> disbursementConfirmation(@RequestBody ResultResponseB2C responseB2C) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Message("Payment request timeout. Please try again later"));
    }

    @PostMapping("disbursement/payment-timeout")
    public ResponseEntity<?> disbursementTimeOut(@RequestBody ResultResponseB2C responseB2C) {
        return ResponseEntity.ok().body(new Message("Bulk disbursement completed successfully with Mpesa " +
                "transaction code " + responseB2C.getResult().getTransactionID()));
    }

}
