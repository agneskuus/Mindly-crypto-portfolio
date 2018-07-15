package com.Mindly.cryptoPortfolio.controller;

import com.Mindly.cryptoPortfolio.model.Portfolio;
import com.Mindly.cryptoPortfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    private PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioController(PortfolioRepository portfolioRepository){
        this.portfolioRepository = portfolioRepository;
    }

    @RequestMapping(value = "portfolio", method = RequestMethod.GET)
    public ResponseEntity<List<Portfolio>> getPortfolioItems() {
        List<Portfolio> portfolioItems = portfolioRepository.findAll();
        if (portfolioItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(portfolioItems, HttpStatus.OK);
    }
}
