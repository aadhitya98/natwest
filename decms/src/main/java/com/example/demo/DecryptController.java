package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.util.Base64;


@RestController
public class DecryptController {


    private static Key key;
    private static Cipher cipher;

    @Autowired
     TransactionDetailsRepo transactionDetailsRepo;

    @PostMapping("/decryptandstore")
    private void decryptAndStore(TransactionDetails transactionDetails) {
        try {
            ResponseEntity<String> response
                    = new RestTemplate().getForEntity(
                    "http://localhost:8080/encryptjson",String.class, transactionDetails
                    );
            System.out.println(response);
            String decryptedResponse = decrypt(String.valueOf(response));

            ObjectMapper objectMapper = new ObjectMapper();
            TransactionDetails transactionDetails1 = objectMapper.readValue(decryptedResponse.toString(),TransactionDetails.class);
            transactionDetailsRepo.save(transactionDetails1);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static String decrypt(String encryptedJWT) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new
                String(cipher.doFinal(Base64.getDecoder().decode(encryptedJWT)));
    }
}
