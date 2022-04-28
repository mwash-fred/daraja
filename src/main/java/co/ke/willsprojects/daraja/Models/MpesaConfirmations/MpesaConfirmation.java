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
    @Column(length = 12)
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

}
