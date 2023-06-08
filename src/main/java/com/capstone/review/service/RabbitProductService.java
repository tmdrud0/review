package com.capstone.review.service;

import com.capstone.review.domain.Product;
import com.capstone.review.repository.RabbitProductRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class RabbitProductService{

    @Autowired
    private final RabbitProductRepository rabbitProductRepository;
    private final JSONParser parser = new JSONParser();

    public Product getProductByName(String name) {
        return null;
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            rabbitProductRepository.send(name);
            String data = rabbitProductRepository.receive();
            JSONObject object = (JSONObject) parser.parse(data);
            JSONArray products = (JSONArray) object.get("products");
            for(int i=0;i<products.size();i++){
                JSONObject curProduct = (JSONObject) products.get(i);
                result.add(Product.builder().
                        name((String)curProduct.get("name"))
                        .price(Long.parseLong((String)curProduct.get("price")))
                        .category((String)curProduct.get("category"))
                        .build());
            }
        }catch (Exception e){}
        return result;
    }
}

