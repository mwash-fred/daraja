package co.ke.willsprojects.daraja.Utils;

import org.springframework.beans.factory.annotation.Value;

public class CONSTANTS {
    public static final String authenticationUrl = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    @Value("${app.consumer.key}")
    public static String consumerKey;
    @Value("${app.consumer.secret}")
    public static String consumerSecret;
}
