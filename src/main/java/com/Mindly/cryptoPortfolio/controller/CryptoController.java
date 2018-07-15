package com.Mindly.cryptoPortfolio.controller;

import com.Mindly.cryptoPortfolio.model.Crypto;
import com.Mindly.cryptoPortfolio.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CryptoController {

    private CryptoRepository cryptoRepository;

    @Autowired
    public CryptoController(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @RequestMapping(value = "cryptos", method = RequestMethod.GET)
    public ResponseEntity<List<Crypto>> getCryptos() {
        List<Crypto> cryptos = cryptoRepository.findAll();
        if (cryptos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cryptos, HttpStatus.OK);

    }
}
