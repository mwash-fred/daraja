package co.ke.willsprojects.daraja.Processes;

import co.ke.willsprojects.daraja.Interface.PartTran;
import co.ke.willsprojects.daraja.Models.MpesaConfirmations.MpesaConfirmation;
import co.ke.willsprojects.daraja.Models.MpesaConfirmations.MpesaConfirmationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component @Slf4j
public class ScheduledProcesses {

    @Autowired
    private MpesaConfirmationRepository repository;

//    @Scheduled(fixedRate = 10000000000L)
    public void coreTransactions(){
        for (MpesaConfirmation confirmation :  repository.findAll()){
            PartTran partTran = repository.mpesaPart(confirmation.getMpesaTransactionNo());
            if(!Objects.isNull(partTran)){
                confirmation.setCoreTranId(partTran.getTranId().toString());;
            }
        }
        log.info("Completed");
    }
}
