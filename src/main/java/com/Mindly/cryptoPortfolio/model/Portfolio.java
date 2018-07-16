package com.Mindly.cryptoPortfolio.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Crypto.class)
    private Crypto crypto;
    private double amount;
    private Date dateOfPurchase;
    private String location;
    private double value;

    public Portfolio() {
    }

    public Portfolio(Crypto crypto, double amount, Date dateOfPurchase, String location, double value) {
        this.crypto = crypto;
        this.amount = amount;
        this.dateOfPurchase = dateOfPurchase;
        this.location = location;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Crypto getCrypto() {
        return crypto;
    }

    public void setCrypto(Crypto crypto) {
        this.crypto = crypto;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
