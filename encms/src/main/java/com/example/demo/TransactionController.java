package com.example.demo;

import cn.licoy.encryptbody.annotation.encrypt.EncryptBody;
import cn.licoy.encryptbody.enums.EncryptBodyMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

import static com.example.demo.EncryptionUtility.decrypt;
import static com.example.demo.EncryptionUtility.encrypt;

@RestController
public class TransactionController {

    @PostMapping("/encryptjson")
    private ResponseEntity<String> encryptJson(@RequestBody TransactionDetails transactionDetails) throws Exception {
        Queue<String> queue = new LinkedList<>();
        String tdetails = encrypt(transactionDetails);
        queue.add(tdetails);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            return new ResponseEntity<String>(queue.poll(), HttpStatus.OK);
        }
        return null;
    }


}
