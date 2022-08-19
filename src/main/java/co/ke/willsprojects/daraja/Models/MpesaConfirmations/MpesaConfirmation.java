package co.ke.willsprojects.daraja.Models.MpesaConfirmations;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MpesaConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    @Column(length = 200)
    private String customerName;
    @Column(length = 20)
    private String phoneNumber;
    @Column(precision = 10, scale = 2)
    private Double transactionAmount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTime;
    @Column(length = 10)
    private String paybillNo;
    @Column(length = 10)
    private String mpesaTransactionNo;
    @Column(length = 20)
    private String transactionType; // bulk disbursement or mpesa repayment
    @Column(length = 10)
    private String coreTranId;
    private Boolean transactionStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date corePostedTime;
    @Column(nullable = false, length = 20)
    private String customerId;

    public MpesaConfirmation() {
    }

    public MpesaConfirmation(Long sn, String customerName, String phoneNumber, Double transactionAmount, Date transactionTime, String paybillNo, String mpesaTransactionNo, String transactionType, String coreTranId, Boolean transactionStatus, Date corePostedTime, String customerId) {
        this.sn = sn;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.transactionAmount = transactionAmount;
        this.transactionTime = transactionTime;
        this.paybillNo = paybillNo;
        this.mpesaTransactionNo = mpesaTransactionNo;
        this.transactionType = transactionType;
        this.coreTranId = coreTranId;
        this.transactionStatus = transactionStatus;
        this.corePostedTime = corePostedTime;
        this.customerId = customerId;
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getPaybillNo() {
        return paybillNo;
    }

    public void setPaybillNo(String paybillNo) {
        this.paybillNo = paybillNo;
    }

    public String getMpesaTransactionNo() {
        return mpesaTransactionNo;
    }

    public void setMpesaTransactionNo(String mpesaTransactionNo) {
        this.mpesaTransactionNo = mpesaTransactionNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCoreTranId() {
        return coreTranId;
    }

    public void setCoreTranId(String coreTranId) {
        this.coreTranId = coreTranId;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getCorePostedTime() {
        return corePostedTime;
    }

    public void setCorePostedTime(Date corePostedTime) {
        this.corePostedTime = corePostedTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
