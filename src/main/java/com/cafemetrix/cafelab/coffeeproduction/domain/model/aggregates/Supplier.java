package com.cafemetrix.cafelab.coffeeproduction.domain.model.aggregates;

import com.cafemetrix.cafelab.coffeeproduction.domain.model.valueobjects.*;

public class Supplier {
    private final SupplierId id;
    private final UserId userId;
    private String name;
    private EmailAddress email;
    private PhoneNumber phone;
    private Location location;
    private Specialty specialty;

    public Supplier(SupplierId id, UserId userId, String name, EmailAddress email, PhoneNumber phone, Location location, Specialty specialty) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.specialty = specialty;
    }

    public SupplierId getId() { return id; }
    public UserId getUserId() { return userId; }
    public String getName() { return name; }
    public EmailAddress getEmail() { return email; }
    public PhoneNumber getPhone() { return phone; }
    public Location getLocation() { return location; }
    public Specialty getSpecialty() { return specialty; }

    public void setName(String name) { this.name = name; }
    public void setEmail(EmailAddress email) { this.email = email; }
    public void setPhone(PhoneNumber phone) { this.phone = phone; }
    public void setLocation(Location location) { this.location = location; }
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }
} 