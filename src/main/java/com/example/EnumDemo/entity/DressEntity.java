package com.example.EnumDemo.entity;

import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Size;
import com.example.EnumDemo.enumC.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_id;
    private String brand;
    private Color color;
    private Size size;
    private Type type;
}
