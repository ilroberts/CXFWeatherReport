package com.ilroberts.receiver;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.ilroberts.dto.NewDataSetDTO;
import com.ilroberts.dto.TableDTO;
import com.ilroberts.model.City;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ilroberts.mapper.TableToCityMapper.mapTableToCity;

public final class CityReceiver implements Receiver<List<City>> {

    @Override
    public List<City> receive() {

        GlobalWeather weather = new GlobalWeather();
        GlobalWeatherSoap soapRequest = weather.getGlobalWeatherSoap();

        String cityList = soapRequest.getCitiesByCountry("United Kingdom");

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);
        mapper.registerModule(new JaxbAnnotationModule());

        try {
            NewDataSetDTO dataset = mapper.readValue(cityList, NewDataSetDTO.class);
            Stream<TableDTO> tables = dataset.getTable().stream();
            return tables.map(t -> mapTableToCity(t).get()).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
