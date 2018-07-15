package com.Mindly.cryptoPortfolio.repository;

import com.Mindly.cryptoPortfolio.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
}
