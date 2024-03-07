package com.example.EnumDemo.service;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.dto.ShowDressDto;
import com.example.EnumDemo.entity.DressEntity;
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

    public List<ShowDressDto> showDresses() {
        List<ShowDressDto> returnDresses = dressMapper.entityToShowDressDto(dressRepository.findAll()
                .stream().map(dressMapper::entityToShowDressDto).collect(Collectors.toList()));
        return returnDresses;
    }

    public List<ShowDressDto> filterDresses(List<Color> colors, Color color, Size size, Type type, String brand,
                                            Double lowerPrice, Double upperPrice, boolean notColor,
                                            boolean priceBetween, boolean priceLessThanEqual, boolean priceGreaterThanEqual) {
        if (colors != null && !colors.isEmpty()) {
            List<DressEntity> dressEntities = dressRepository.findByColorIn(colors);
            List<ShowDressDto> showDressDtos = dressEntities.stream()
                    .map(dressMapper::entityToShowDressDto)
                    .collect(Collectors.toList());
            return showDressDtos;
        }

        if (color != null && size != null && type != null && brand != null) {
            List<DressEntity> dressEntities = dressRepository.findByColorAndBrandAndSizeAndType(type, brand, color, size);
            List<ShowDressDto> showDressDtos = dressEntities.stream()
                    .map(dressMapper::entityToShowDressDto)
                    .collect(Collectors.toList());
            return showDressDtos;
        }

        if (size != null && type != null && brand != null) {
            if (notColor) {
                List<DressEntity> dressEntities = dressRepository.findByBrandAndTypeAndSizeNot(brand, type, size);
                List<ShowDressDto> showDressDtos = dressEntities.stream()
                        .map(dressMapper::entityToShowDressDto)
                        .collect(Collectors.toList());
                return showDressDtos;
            } else {
                List<DressEntity> dressEntities = dressRepository.findBySizeAndTypeAndBrandOrColor(size, type, brand, color);
                List<ShowDressDto> showDressDtos = dressEntities.stream()
                        .map(dressMapper::entityToShowDressDto)
                        .collect(Collectors.toList());
                return showDressDtos;
            }
            }

            if (priceBetween) {
                List<DressEntity> dressEntities = dressRepository.findByPriceBetween(lowerPrice, upperPrice);
                List<ShowDressDto> showDressDtos = dressEntities.stream()
                        .map(dressMapper::entityToShowDressDto)
                        .collect(Collectors.toList());
                return showDressDtos;
            } else if (priceLessThanEqual) {
                List<DressEntity> dressEntities = dressRepository.findByPriceLessThanEqual(lowerPrice);
                List<ShowDressDto> showDressDtos = dressEntities.stream()
                        .map(dressMapper::entityToShowDressDto)
                        .collect(Collectors.toList());
                return showDressDtos;
            } else if (priceGreaterThanEqual) {
                List<DressEntity> dressEntities = dressRepository.findByPriceGreaterThanEqual(upperPrice);
                List<ShowDressDto> showDressDtos = dressEntities.stream()
                        .map(dressMapper::entityToShowDressDto)
                        .collect(Collectors.toList());
                return showDressDtos;
            }

            // If no filters are provided, return all dresses
            List<DressEntity> dressEntities = dressRepository.findAll();
            List<ShowDressDto> showDressDtos = dressEntities.stream()
                    .map(dressMapper::entityToShowDressDto)
                    .collect(Collectors.toList());
            return showDressDtos;
        }
    }

