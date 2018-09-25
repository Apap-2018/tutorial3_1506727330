package com.apap.tutorial3.service;

import com.apap.tutorial3.model.CarModel;

import java.util.List;

public interface CarService {
    void addCar(CarModel car);

    List<CarModel> getCarList();

    CarModel getCarDetail(String id);
}
