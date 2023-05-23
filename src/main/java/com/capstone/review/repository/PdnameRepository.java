package com.capstone.review.repository;

import com.capstone.review.entity.ProductName;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PdnameRepository extends CrudRepository<ProductName, Long> {
    //entity 이름, id type
    @Override
    ArrayList<ProductName> findAll();
}