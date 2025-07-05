package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

import java.util.List;

public record UpdateSupplierRequest(
    String name,
    String email,
    String phone,
    String location,
    List<String> specialties
) {} 