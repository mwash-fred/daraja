package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConfirmationC2BRequest {
    @JsonProperty("TransactionType")
    private String transactionType;
    @JsonProperty("TransID")
    private String transactionID;
    @JsonProperty("TransTime")
    private String transactionTime;
    @JsonProperty("TransAmount")
    private String transactionAmount;
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;
    @JsonProperty("BillRefNumber")
    private String billRefNo;
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("OrgAccountBalance")
    private String thirdPartyTanorgAccountBalancesID;
    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransId;
    @JsonProperty("MSISDN")
    private String msisdn;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middlename;
    @JsonProperty("LastName")
    private String lastName;
}
