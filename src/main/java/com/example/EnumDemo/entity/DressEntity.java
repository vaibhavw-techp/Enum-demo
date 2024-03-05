package com.example.EnumDemo.entity;

import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DressEntity {
    private Long id;
    private String brand;
    private Color color;
    private Long size;
    private Type type;
}
