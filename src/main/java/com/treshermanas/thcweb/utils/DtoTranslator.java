package com.treshermanas.thcweb.utils;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public final class DtoTranslator {

    public static <T, D> D convertObjectToDto(T srcObj, Class<D> dtoClass) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(srcObj, dtoClass);
    }

    public static <T, D> List<D> convertListToDtoList(List<T> srcList, Class<D> dtoClass) {
        ModelMapper modelMapper = new ModelMapper();
        java.lang.reflect.Type type = new TypeToken<List<D>>() {
        }.getType();
        return modelMapper.map(srcList, type);
    }

}
