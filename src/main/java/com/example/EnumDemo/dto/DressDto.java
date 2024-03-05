package com.example.EnumDemo.dto;

import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DressDto {

    private String brand;
    private Color color;
    private Long size;
    private Type type;
}
