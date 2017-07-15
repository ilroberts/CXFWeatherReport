package com.ilroberts;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.ilroberts.service.WeatherService;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new WeatherModule());

        //WeatherService weatherService = injector.getInstance(WeatherService.class);

        WeatherService weatherService =
                injector.getInstance(Key.get(new TypeLiteral<WeatherService>() {}));

        int cityCount = weatherService.getCitiesFromCountry().size();
        System.out.println("number of cities = " + cityCount);

    }
}
