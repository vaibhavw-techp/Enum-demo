package com.example.EnumDemo.service;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.dto.showDressDto;
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

    public DressDto addDress(@RequestBody DressDto dressDto){
        DressEntity dressEntity = new DressEntity();
        dressEntity = dressMapper.dtoToEntity(dressDto);
        dressRepository.save(dressEntity);
        return dressDto;
    }

    public List<showDressDto> showDresses(){
        List<showDressDto> returnDresses = dressMapper.entityToShowDressDto(dressRepository.findAll()
                .stream().collect(Collectors.toList()));
        return returnDresses;
    }
}
