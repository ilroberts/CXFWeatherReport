package com.ilroberts.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.Inject;

public class WeatherService {

    private final XmlMapper mapper;

    @Inject
    WeatherService(XmlMapper mapper) {
        this.mapper = mapper;
    }

    public void getCitiesFromCountry() {

        // do stuff
    }
}
