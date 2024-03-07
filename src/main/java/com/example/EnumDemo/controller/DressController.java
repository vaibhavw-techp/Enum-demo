package com.example.EnumDemo.controller;

import com.example.EnumDemo.dto.DressDto;
import com.example.EnumDemo.dto.DressInfoDto;
import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Size;
import com.example.EnumDemo.enumC.Type;
import com.example.EnumDemo.repository.DressRepository;
import com.example.EnumDemo.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dresses")
public class DressController {

    @Autowired
    private DressService dressService;

    @PostMapping
    public DressDto addDress(@RequestBody DressDto dressDto){
       return dressService.addDress(dressDto);
    }

    @GetMapping()
    public List<DressInfoDto> filterDresses(@RequestParam(required = false) List<Color> colors, @RequestParam(required = false) Color color,
                                            @RequestParam(required = false) Size size, @RequestParam(required = false) Type type, @RequestParam(required = false) String brand,
                                            @RequestParam(required = false) Double lowerPrice, @RequestParam(required = false) Double upperPrice,
                                            @RequestParam(required = false, defaultValue = "false") boolean notColor,
                                            @RequestParam(required = false, defaultValue = "false") boolean priceBetween,
                                            @RequestParam(required = false, defaultValue = "false") boolean priceLessThanEqual,
                                            @RequestParam(required = false, defaultValue = "false") boolean priceGreaterThanEqual) {
        return dressService.filterDresses(colors, color, size, type, brand, lowerPrice, upperPrice, notColor,
                priceBetween, priceLessThanEqual, priceGreaterThanEqual);
    }


}
