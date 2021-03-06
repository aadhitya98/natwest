package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionDetails {

    @Id
    public String accountNumber;
    public String type;
    public String amount;
    public String currency;
    public String accountFrom;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", accountFrom='" + accountFrom + '\'' +
                '}';
    }
}
