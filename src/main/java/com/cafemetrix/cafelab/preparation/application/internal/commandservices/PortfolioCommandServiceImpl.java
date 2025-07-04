package com.cafemetrix.cafelab.preparation.application.internal.commandservices;

import com.cafemetrix.cafelab.preparation.domain.model.aggregates.Portfolio;
import com.cafemetrix.cafelab.preparation.domain.model.commands.CreatePortfolioCommand;
import com.cafemetrix.cafelab.preparation.domain.services.PortfolioCommandService;
import com.cafemetrix.cafelab.preparation.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioCommandServiceImpl implements PortfolioCommandService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioCommandServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public Long handle(CreatePortfolioCommand command) {
        var portfolio = new Portfolio(command);
        portfolio = portfolioRepository.save(portfolio);
        return portfolio.getId();
    }
} 