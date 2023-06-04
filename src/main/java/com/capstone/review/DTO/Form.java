package com.capstone.review.DTO;

import com.capstone.review.entity.ProductName;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Form {

    private String content;

    public ProductName toEntity() {
        return new ProductName(null, content); // ProductName = entity class -> 생성자 추가
    }

    public String getContent() {
        return content;
    }
}
