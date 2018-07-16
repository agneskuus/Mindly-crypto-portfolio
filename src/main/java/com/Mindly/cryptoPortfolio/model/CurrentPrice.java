package com.Mindly.cryptoPortfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentPrice {

    @JsonProperty("high")
    private double currentPrice;

    public CurrentPrice() {
    }

    public CurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getMarketValue(double amount) {
        return currentPrice*amount;
    }
}
