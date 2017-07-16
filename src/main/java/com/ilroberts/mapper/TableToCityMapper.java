package com.ilroberts.mapper;


import com.ilroberts.dto.TableDTO;
import com.ilroberts.model.City;

import java.util.Optional;

public class TableToCityMapper implements Mapper<TableDTO, City> {

    public Optional<City> map(TableDTO table) {

        if(table != null) {

            return Optional.of(new City(table.getCountry(), table.getCity()));
        }
       return Optional.empty();
    }
}
