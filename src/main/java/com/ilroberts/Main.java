package com.ilroberts;


import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        GlobalWeather weather = new GlobalWeather();
        GlobalWeatherSoap soapReqest = weather.getGlobalWeatherSoap();

        System.out.println(soapReqest.getCitiesByCountry("United Kingdom"));
    }
}
