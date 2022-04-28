package co.ke.willsprojects.daraja.Components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

@Component
@Slf4j
public class PasswordEncrypt {

    public String generateSecurityCredentials(String certificate, String initiatorPassword) {
        try {
            InputStream is = new ByteArrayInputStream(certificate.getBytes());
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(is);

            PublicKey pubKey = cert.getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            byte[] cipherBytes = cipher.doFinal(initiatorPassword.getBytes());
            String encrypted = Base64.getEncoder().encodeToString(cipherBytes);
            return encrypted;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
