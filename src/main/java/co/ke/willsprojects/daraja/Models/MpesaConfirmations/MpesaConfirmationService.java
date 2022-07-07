package co.ke.willsprojects.daraja.Models.MpesaConfirmations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MpesaConfirmationService {
    @Autowired
    private MpesaConfirmationRepository repository;

    public MpesaConfirmation saveConfirmation(MpesaConfirmation confirmation){
        return repository.save(confirmation);
    }

    public MpesaConfirmation updateConfirmation(MpesaConfirmation confirmation){
        return repository.save(confirmation);
    }


}
