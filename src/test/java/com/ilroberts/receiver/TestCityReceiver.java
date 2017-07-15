package com.ilroberts.receiver;

import com.ilroberts.model.City;

import java.util.ArrayList;
import java.util.List;

public class TestCityReceiver implements Receiver<List<City>> {

    public List<City> receive() {
        City city = new City("United Kingdom", "London");
        List<City> cities = new ArrayList();
        cities.add(city);
        return cities;
    }

}
