package com.apap.tutorial3.model;

public class CarModel {
    private String id;
    private String brand;
    private String type;
    private Long price;
    private Integer amount;

    public CarModel(String id, String brand, String type, Long price, Integer amount) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (!(other instanceof CarModel)) {
            return false;
        }
        CarModel car = (CarModel) other;
        return this.getId().equals(car.getId());
    }
}
