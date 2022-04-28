package co.ke.willsprojects.daraja.JsonSchemas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ConfirmationRequest {

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("BillRefNumber")
    private String billRefNumber;

    @JsonProperty("MSISDN")
    private String mSISDN;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("BusinessShortCode")
    private String businessShortCode;

    @JsonProperty("OrgAccountBalance")
    private Double orgAccountBalance;

    @JsonProperty("TransAmount")
    private Double transAmount;

    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransID;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("TransID")
    private String transID;

    @JsonProperty("TransTime")
    private Date transTime;
}