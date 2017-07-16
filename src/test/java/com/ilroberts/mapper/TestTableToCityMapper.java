package com.ilroberts.mapper;


import com.ilroberts.dto.TableDTO;
import com.ilroberts.model.City;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

public class TestTableToCityMapper {

    @Test
    public void testMapSuccess() {

        TableDTO table = new TableDTO();
        table.setCountry("United Kingdom");
        table.setCity("London");

        TableToCityMapper mapper = new TableToCityMapper();

        Optional<City> city = mapper.map(table);
        assertThat(city.get().cityName,is("London"));
    }

    @Test
    public void testMapNullTable() {


        TableToCityMapper mapper = new TableToCityMapper();

        Optional<City> city = mapper.map(null);
        assertThat(city.isPresent(),is(false));
    }
}
