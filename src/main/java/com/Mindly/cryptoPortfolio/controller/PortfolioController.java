package com.Mindly.cryptoPortfolio.controller;

import com.Mindly.cryptoPortfolio.model.Portfolio;
import com.Mindly.cryptoPortfolio.repository.PortfolioRepository;
import com.Mindly.cryptoPortfolio.service.MarketValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "portfolio", method = RequestMethod.POST)
    public ResponseEntity<?> createPortfolioItem(@RequestBody Portfolio portfolioItem) {

        if (portfolioItem.getId() != null && portfolioRepository.existsById(portfolioItem.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (portfolioItem.getDateOfPurchase() == null) {
            portfolioItem.setDateOfPurchase(Date.valueOf(LocalDate.now()));
        }

        String cryptoSymbol = portfolioItem.getCrypto().getSymbol();
        double currentMarketValue = MarketValueService.getMarketValue(portfolioItem.getAmount(), cryptoSymbol);
        portfolioItem.setValue(currentMarketValue);

        Portfolio createdPortfolioItem = portfolioRepository.save(portfolioItem);
        return new ResponseEntity<>(createdPortfolioItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "portfolio/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePortfolioItem(@PathVariable("id") long id) {
        Optional<Portfolio> portfolioItem = portfolioRepository.findById(id);
        if (portfolioItem.isPresent()) {
            Portfolio item = portfolioItem.get();
            portfolioRepository.delete(item);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
