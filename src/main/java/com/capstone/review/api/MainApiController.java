package com.capstone.review.api;

import com.capstone.review.entity.ProductName;
import com.capstone.review.repository.PdnameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainApiController {

    @Autowired
    private PdnameRepository pdnameRepository;
    @GetMapping("/api/searched")
    public List<ProductName> index() {
        return pdnameRepository.findAll();
    }

    @GetMapping("/api/searched/{id}")
    public ProductName show(@PathVariable Long id){
        return pdnameRepository.findById(id).orElse(null);
    }
}
