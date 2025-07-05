package com.cafemetrix.cafelab.preparation.domain.services;

import com.cafemetrix.cafelab.preparation.domain.model.commands.CreatePortfolioCommand;

/**
 * Interface for Portfolio Command Service
 */
public interface PortfolioCommandService {
    Long handle(CreatePortfolioCommand command);
} 