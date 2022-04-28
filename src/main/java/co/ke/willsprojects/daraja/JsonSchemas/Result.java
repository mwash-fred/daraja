package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("ConversationID")
    private String conversationID;

    @JsonProperty("ReferenceData")
    private ReferenceData referenceData;

    @JsonProperty("OriginatorConversationID")
    private String originatorConversationID;

    @JsonProperty("ResultDesc")
    private String resultDesc;

    @JsonProperty("ResultType")
    private int resultType;

    @JsonProperty("ResultCode")
    private int resultCode;

    @JsonProperty("ResultParameters")
    private ResultParameters resultParameters;

    @JsonProperty("TransactionID")
    private String transactionID;

    public String getConversationID() {
        return conversationID;
    }

    public ReferenceData getReferenceData() {
        return referenceData;
    }

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public int getResultType() {
        return resultType;
    }

    public int getResultCode() {
        return resultCode;
    }

    public ResultParameters getResultParameters() {
        return resultParameters;
    }

    public String getTransactionID() {
        return transactionID;
    }
}