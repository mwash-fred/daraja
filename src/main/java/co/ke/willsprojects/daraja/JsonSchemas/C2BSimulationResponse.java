package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2BSimulationResponse {

    @JsonProperty("ConversationID")
    private String conversationID;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorCoversationID")
    private String originatorCoversationID;
}