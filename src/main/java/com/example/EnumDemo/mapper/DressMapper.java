package com.example.EnumDemo.mapper;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.dto.ShowDressDto;
import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.enumC.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DressMapper {

    @Mapping(target = "size", source = "dressDto.size", qualifiedByName = ("getDressSize"))
    @Mapping(target = "brand", source = "dressDto.brand")
    @Mapping(target = "color", source = "dressDto.color")
    @Mapping(target = "type", source = "dressDto.type")
    @Mapping(target = "price", source = "dressDto.price")
    DressEntity dtoToEntity(DressDto dressDto);

//    @Mapping(target = "size",source = "dressDto.size")
//    @Mapping(target = "brand", source = "dressDto.brand")
//    @Mapping(target = "color", source = "dressDto.color")
//    @Mapping(target = "type", source = "dressDto.type")
//    @Mapping(target = "price", source = "dressDto.price")
//    List<ShowDressDto> entitiesToShowDressDto(List<DressEntity> dressEntity);

    @Mapping(target = "size",source = "dressDto.size")
    @Mapping(target = "brand", source = "dressDto.brand")
    @Mapping(target = "color", source = "dressDto.color")
    @Mapping(target = "type", source = "dressDto.type")
    @Mapping(target = "price", source = "dressDto.price")
    ShowDressDto entityToShowDressDto(DressEntity dressEntity);

    @Named("getDressSize")
    default Size getDressSize(Long size){
        return Size.rangeConversion(size);
    }

    @Named("getDressSizeToLong")
    default Long getDressSizeLong1(Size size){
      return Size.getDressSizeLong1(size);
    }

}
