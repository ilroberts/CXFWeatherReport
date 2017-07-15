package com.ilroberts.service;

import com.google.inject.Inject;
import com.ilroberts.model.City;
import com.ilroberts.receiver.Receiver;

import java.util.List;

public class WeatherService {

    private final Receiver<List<City>> receiver;

    @Inject
    WeatherService(Receiver<List<City>> receiver) {
        this.receiver = receiver;
    }

    public List<City> getCitiesFromCountry() {

        return receiver.receive();
    }
}
