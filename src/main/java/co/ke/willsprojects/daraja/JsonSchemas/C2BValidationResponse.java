package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class C2BValidationResponse {

    @JsonProperty("ResultDesc")
    private String resultDesc;

    @JsonProperty("ResultCode")
    private int resultCode;
}