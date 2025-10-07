package com.skybook.models;

public class Airline {
    private String id;
    private String name;
    private String code;
    private String color;
    private double basePrice;
    private String logoUrl;

    public Airline(String id, String name, String code, String color, double basePrice, String logoUrl) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.color = color;
        this.basePrice = basePrice;
        this.logoUrl = logoUrl;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
    
    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    @Override
    public String toString() {
        return "Airline{name='" + name + "', code='" + code + "', basePrice=" + basePrice + "}";
    }
}
