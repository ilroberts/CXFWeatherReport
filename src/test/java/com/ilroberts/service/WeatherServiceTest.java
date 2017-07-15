package com.ilroberts.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.ilroberts.TestWeatherModule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherServiceTest {

    @Test
    public void testWeatherService() {

        Injector injector = Guice.createInjector(new TestWeatherModule());

        WeatherService weatherService =
                injector.getInstance(Key.get(new TypeLiteral<WeatherService>() {}));

        int cityCount = weatherService.getCitiesFromCountry().size();
        System.out.println("number of cities = " + cityCount);

        assertThat(cityCount, is(1));
    }
}
