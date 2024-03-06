package com.example.EnumDemo.service;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.dto.showDressDto;
import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Size;
import com.example.EnumDemo.enumC.Type;
import com.example.EnumDemo.mapper.DressMapper;
import com.example.EnumDemo.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DressService {

    @Autowired
    private DressMapper dressMapper;

    @Autowired
    private DressRepository dressRepository;

    public DressDto addDress(@RequestBody DressDto dressDto) {
        DressEntity dressEntity = new DressEntity();
        dressEntity = dressMapper.dtoToEntity(dressDto);
        dressRepository.save(dressEntity);
        return dressDto;
    }

    public List<showDressDto> showDresses() {
        List<showDressDto> returnDresses = dressMapper.entityToShowDressDto(dressRepository.findAll()
                .stream().collect(Collectors.toList()));
        return returnDresses;
    }

    public List<showDressDto> filterDresses(List<Color> colors, Color color, Size size, Type type, String brand,
                                            Double lowerPrice, Double upperPrice, boolean notColor,
                                            boolean priceBetween, boolean priceLessThanEqual, boolean priceGreaterThanEqual) {
        if (colors != null && !colors.isEmpty()) {
            return dressMapper.entityToShowDressDto(dressRepository.findByColorIn(colors)
                    .stream().collect(Collectors.toList()));
        }

        if (color != null && size != null && type != null && brand != null) {
            return dressMapper.entityToShowDressDto(dressRepository.findByColorAndBrandAndSizeAndType(type, brand, color, size)
                    .stream().collect(Collectors.toList()));
        }

        if (size != null && type != null && brand != null) {
            if (notColor) {
                return dressMapper.entityToShowDressDto(dressRepository.findByBrandAndTypeAndSizeNot(brand, type, size)
                        .stream().collect(Collectors.toList()));
            } else {
                return dressMapper.entityToShowDressDto(dressRepository.findBySizeAndTypeAndBrandOrColor(size, type, brand, color)
                        .stream().collect(Collectors.toList()));
            }
            }

            if (priceBetween) {
                return dressMapper.entityToShowDressDto(dressRepository.findByPriceBetween(lowerPrice, upperPrice)
                        .stream().collect(Collectors.toList()));
            } else if (priceLessThanEqual) {
                return dressMapper.entityToShowDressDto(dressRepository.findByPriceLessThanEqual(lowerPrice)
                        .stream().collect(Collectors.toList()));
            } else if (priceGreaterThanEqual) {
                return dressMapper.entityToShowDressDto(dressRepository.findByPriceGreaterThanEqual(upperPrice)
                        .stream().collect(Collectors.toList()));
            }

            // If no filters are provided, return all dresses
            return dressMapper.entityToShowDressDto(dressRepository.findAll()
                    .stream().collect(Collectors.toList()));
        }
    }

