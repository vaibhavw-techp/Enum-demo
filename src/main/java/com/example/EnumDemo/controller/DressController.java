package com.example.EnumDemo.controller;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.mapper.DressMapper;
import com.example.EnumDemo.repository.DressRepository;
import com.example.EnumDemo.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dresses")
public class DressController {

    @Autowired
    private DressService dressService;

    @Autowired
    private DressRepository dressRepository;

    @PostMapping
    public DressDto addDress(@RequestBody DressDto dressDto){
       return dressService.addDress(dressDto);
    }

    @GetMapping
    public List<DressEntity> showDresses(){
        return dressService.showDresses();
    }

}
