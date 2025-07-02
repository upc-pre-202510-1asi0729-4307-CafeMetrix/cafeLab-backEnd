package com.cafemetrix.cafelab.coffeemanagement.interfaces.rest.dto;

public record LaborCostDto(Double hoursWorked, Double costPerHour, Integer numberOfWorkers, Double totalCost) {} 