package co.ke.willsprojects.daraja.Interface;

import java.util.Date;

public interface PartTran {
    Long getSn();
    Integer getPartTranSn();
    String getPartTranType();
    Double getTranAmount();
    String getAcid();
    Date gwtTranDate();
    String getTranParticulars();
    Long getTranId();
}
