package com.ilroberts.transformer;

import com.google.inject.Inject;
import com.ilroberts.dto.TableDTO;
import com.ilroberts.mapper.Mapper;
import com.ilroberts.model.City;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public final class TableToCityTransformer implements Transformer<List<TableDTO>, List<City>> {

    private final Mapper<TableDTO, City> mapper;

    @Inject
    public TableToCityTransformer(Mapper<TableDTO, City> converter) {
        this.mapper = converter;
    }

    public List<City> transform(List<TableDTO> tables ) {

        return tables.stream()
                .map(mapper::map)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
