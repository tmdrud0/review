package com.capstone.review.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity // DB가 해당 객체 인식 가능
public class ProductName {
    @Id // 대표값 지정
    @GeneratedValue // 자동 생성
    private Long id;

    @Column
    private String content;
}
