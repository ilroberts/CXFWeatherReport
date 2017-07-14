package com.ilroberts;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.ilroberts.dto.NewDataSetDTO;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GlobalWeather weather = new GlobalWeather();
        GlobalWeatherSoap soapRequest = weather.getGlobalWeatherSoap();

        String cities = soapRequest.getCitiesByCountry("United Kingdom");

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);
        mapper.registerModule(new JaxbAnnotationModule());

        NewDataSetDTO dataset = mapper.readValue(cities, NewDataSetDTO.class);
        System.out.println("number of cities returned = " + dataset.getTable().size());
    }
}
