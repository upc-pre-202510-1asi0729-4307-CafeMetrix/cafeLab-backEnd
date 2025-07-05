package com.cafemetrix.cafelab.coffeeproduction.interfaces.rest.dto;

import java.util.List;

public record CreateSupplierRequest(
    String name,
    String email,
    String phone,
    String location,
    List<String> specialties
) {} 