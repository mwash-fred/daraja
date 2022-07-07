package co.ke.willsprojects.daraja.JsonSchemas;

import lombok.Data;

import java.util.Date;

@Data
public class CoreResponse {
    public Boolean transactionStatus;
    public String transactionNo;
    public Date postedTime;
}
