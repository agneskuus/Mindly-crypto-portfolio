package com.Mindly.cryptoPortfolio.service;

import com.Mindly.cryptoPortfolio.model.CurrentPrice;
import org.springframework.web.client.RestTemplate;

public class MarketValueService {
    public static double getMarketValue(double amount, String symbol){

        String uri = "https://api.bitfinex.com/v1/pubticker/{symbol}";

        RestTemplate restTemplate = new RestTemplate();
        CurrentPrice currentPrice = restTemplate.getForObject(uri, CurrentPrice.class, symbol);
        double currentMarketValue = currentPrice.getMarketValue(amount);
        if (symbol.equals("XRPBTC")){
            double convertedMarketValue = MarketValueService.getMarketValue(currentMarketValue,"BTCEUR");
            return convertedMarketValue;
        }
        return currentMarketValue;
    }
}
