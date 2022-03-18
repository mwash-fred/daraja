package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BValidationResponse {
    @JsonProperty("ResultCode")
    private String resultCode;
    @JsonProperty("ResultDesc")
    private String resultDescription;
}
