package co.ke.willsprojects.daraja.JsonSchemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MpesaRepayment {
    public String msisdn;
    public Double amount;
    public String payerName;
    public  String transactionNo;
}
