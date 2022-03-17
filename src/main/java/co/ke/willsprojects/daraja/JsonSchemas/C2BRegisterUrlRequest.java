package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BRegisterUrlRequest {
    @JsonProperty("ValidationURL")
    private String validationURL;
    @JsonProperty("ConfirmationURL")
    private String confirmationURL;
    @JsonProperty("ResponseType")
    private String resposeType;
    @JsonProperty("ShortCode")
    private String shortCode;
}
