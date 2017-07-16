package com.ilroberts.service;

import com.google.inject.Inject;
import com.ilroberts.dto.TableDTO;
import com.ilroberts.model.City;
import com.ilroberts.receiver.Receiver;
import com.ilroberts.transformer.Transformer;

import java.util.List;

public class WeatherService {

    private final Receiver<List<TableDTO>> receiver;
    private final Transformer<List<TableDTO>, List<City>> transformer;

    @Inject
    WeatherService(Receiver<List<TableDTO>> receiver,
                   Transformer<List<TableDTO>, List<City>> transformer) {
        this.receiver = receiver;
        this.transformer = transformer;
    }

    public List<City> getCitiesFromCountry() {

        List<TableDTO> tables = receiver.receive();
        return transformer.transform(tables);
    }
}
