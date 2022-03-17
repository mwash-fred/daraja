package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class B2CRequest {
    @JsonProperty("InitiatorName")
    private String initiatorName;
    @JsonProperty("SecurityCredential")
    private String securityCredential;
    @JsonProperty("CommandID")
    private String commandID;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("PartyA")
    private String partyA;
    @JsonProperty("PartyB")
    private String partyB;
    @JsonProperty("Remarks")
    private String remarks;
    @JsonProperty("QueueTimeOutURL")
    private String queueTimeoutUrl;
    @JsonProperty("ResultURL")
    private String resultUrl;
    @JsonProperty("Occasion")
    private String occasion;
}
