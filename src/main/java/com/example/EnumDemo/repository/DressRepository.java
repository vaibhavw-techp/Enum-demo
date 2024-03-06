package com.example.EnumDemo.repository;

import com.example.EnumDemo.entity.DressEntity;
import com.example.EnumDemo.enumC.Color;
import com.example.EnumDemo.enumC.Size;
import com.example.EnumDemo.enumC.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DressRepository extends JpaRepository<DressEntity,Long> {
    //IN Clause
    List<DressEntity> findByColorIn(List<Color> colors);

    //3 AND
    List<DressEntity> findByColorAndBrandAndSizeAndType( Type type,String brand,Color color, Size size);

    //2 And 1 OR
    List<DressEntity> findBySizeAndTypeAndBrandOrColor(Size size, Type type, String brand, Color color);

    //Not
    List<DressEntity> findByBrandAndTypeAndSizeNot(String brand, Type type, Size size);

    //Between Clause
    List<DressEntity> findByPriceBetween(double lower_price, double upper_price);

    //Less Than
    List<DressEntity> findByPriceLessThanEqual(double price);

    //Greater Than
    List<DressEntity> findByPriceGreaterThanEqual(double price);
}
