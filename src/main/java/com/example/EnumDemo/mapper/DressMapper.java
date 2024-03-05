package com.example.EnumDemo.mapper;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.enumC.Size;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DressMapper {
    @Mapping(target = "size", source = "dressEntity.size", qualifiedByName = "getDressSizeToLong")
    DressDto entityToDto(DressEntity dressEntity);

    @Mapping(target = "size",source = "dressDto.size",qualifiedByName = "getDressSize")
    @Mapping(target = "brand", source = "dressDto.brand")
    @Mapping(target = "color", source = "dressDto.color")
    @Mapping(target = "type", source = "dressDto.type")
    DressEntity dtoToEntity(DressDto dressDto);

    @Named("getDressSize")
    default Size getDressSize(Long size){
        if(size <= 30) return Size.S;
        else if(size >= 50) return Size.L;
        else return Size.M;
    }

    @Named("getDressSizeToLong")
    default Long getDressSizeLong1(Size size){
        switch (size) {
            case S:
                return 30L;
            case M:
                return 40L; // Adjust according to your business logic
            case L:
                return 50L;
        }
        return 0L;
    }

}
