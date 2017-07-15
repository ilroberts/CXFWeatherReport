package com.ilroberts;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.ilroberts.model.City;
import com.ilroberts.receiver.Receiver;
import com.ilroberts.receiver.TestCityReceiver;

import java.util.List;

public class TestWeatherModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(new TypeLiteral<Receiver<List<City>>>(){}).to(TestCityReceiver.class);
    }
}
