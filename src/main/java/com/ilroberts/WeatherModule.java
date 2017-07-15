package com.ilroberts;


import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.ilroberts.model.City;
import com.ilroberts.receiver.CityReceiver;
import com.ilroberts.receiver.Receiver;

import java.util.List;

public class WeatherModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(new TypeLiteral<Receiver<List<City>>>(){}).to(CityReceiver.class);
    }
}
