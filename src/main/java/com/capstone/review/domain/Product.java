package com.capstone.review.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    String name;
    Long price;
    String category;
}
