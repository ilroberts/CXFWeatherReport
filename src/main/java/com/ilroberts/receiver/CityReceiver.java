package com.ilroberts.receiver;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.ilroberts.dto.NewDataSetDTO;
import com.ilroberts.dto.TableDTO;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CityReceiver implements Receiver<List<TableDTO>> {

    @Override
    public List<TableDTO> receive() {

        GlobalWeather weather = new GlobalWeather();
        GlobalWeatherSoap soapRequest = weather.getGlobalWeatherSoap();

        String cityList = soapRequest.getCitiesByCountry("United Kingdom");

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(module);
        mapper.registerModule(new JaxbAnnotationModule());

        try {
            NewDataSetDTO dataset = mapper.readValue(cityList, NewDataSetDTO.class);
            return dataset.getTable();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
