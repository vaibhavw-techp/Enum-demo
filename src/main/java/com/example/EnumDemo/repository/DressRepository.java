package com.example.EnumDemo.repository;

import com.example.EnumDemo.entity.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressRepository extends JpaRepository<DressEntity,Long> {

}
