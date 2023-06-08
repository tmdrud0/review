package com.capstone.review.controller;

import com.capstone.review.domain.Product;
import com.capstone.review.service.RabbitProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final RabbitProductService rabbitProductService;

    @GetMapping("/products/detail")
    public String list(Model model) {
        model.addAttribute("product", rabbitProductService.getProductByName("test"));
        return "products/productDetail";
    }
    @GetMapping("/products")
    public String test(Model model){
        List<Product> productList = rabbitProductService.getProductsByName("test");
        for(int i=0;i<productList.size();i++)
        model.addAttribute("products",productList);
        return "products/products";
    }
}