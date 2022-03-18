package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class C2BSimulationRequest {
    @JsonProperty("ShortCode")
    private String shortCode;
    @JsonProperty("CommandID")
    private String commandID;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("Msisdn")
    private String msisdn;
    @JsonProperty("BillRefNo")
    private String billRefNo;
}
