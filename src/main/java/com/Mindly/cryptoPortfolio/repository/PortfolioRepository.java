package com.Mindly.cryptoPortfolio.repository;

import com.Mindly.cryptoPortfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
