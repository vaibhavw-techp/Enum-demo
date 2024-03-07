package com.example.EnumDemo.service;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.dto.DressInfoDto;
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

    public List<DressInfoDto> filterDresses(List<Color> colors, Color color, Size size, Type type, String brand,
                                            Double lowerPrice, Double upperPrice, boolean notColor,
                                            boolean priceBetween, boolean priceLessThanEqual, boolean priceGreaterThanEqual) {
        if (colors != null && !colors.isEmpty()) {
            List<DressEntity> dressEntities = dressRepository.findByColorIn(colors);
            List<DressInfoDto> dressDtos = dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
            return dressDtos;
        }

        if (color != null && size != null && type != null && brand != null) {
            List<DressEntity> dressEntities = dressRepository.findByColorAndBrandAndSizeAndType(type, brand, color, size);
            List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
            return dressDtos;
        }

        if (size != null && type != null && brand != null) {
            if (notColor) {
                List<DressEntity> dressEntities = dressRepository.findByBrandAndTypeAndSizeNot(brand, type, size);
                List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
                return dressDtos;
            } else {
                List<DressEntity> dressEntities = dressRepository.findBySizeAndTypeAndBrandOrColor(size, type, brand, color);
                List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
                return dressDtos;
            }
            }

            if (priceBetween) {
                List<DressEntity> dressEntities = dressRepository.findByPriceBetween(lowerPrice, upperPrice);
                List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
                return dressDtos;
            } else if (priceLessThanEqual) {
                List<DressEntity> dressEntities = dressRepository.findByPriceLessThanEqual(lowerPrice);
                List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
                return dressDtos;
            } else if (priceGreaterThanEqual) {
                List<DressEntity> dressEntities = dressRepository.findByPriceGreaterThanEqual(upperPrice);
                List<DressInfoDto> dressDtos = dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
                return dressDtos;
            }

            // If no filters are provided, return all dresses
            List<DressEntity> dressEntities = dressRepository.findAll();
            List<DressInfoDto> dressDtos =  dressMapper.convertDressEntitiesToDressInfoDtos(dressEntities);
            return dressDtos;
        }
    }

