package com.capstone.review.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebClientApplicationTests {

    @Autowired
    private ProductService webClientService;

    @Test
    void get() {
        webClientService.get();
    }
}