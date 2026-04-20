package com.outrowonderstore.outrowonderstrore_api.mapper;

import com.outrowonderstore.outrowonderstrore_api.dto.AmigurumiDto;
import com.outrowonderstore.outrowonderstrore_api.model.Amigurumi;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AmigurumiMapper {

    AmigurumiDto toDtoList(Amigurumi amigurumi);
    Amigurumi toEntity(AmigurumiDto amigurumiDto);
    List<AmigurumiDto> toDtoList(List<Amigurumi> amigurumis);
}
