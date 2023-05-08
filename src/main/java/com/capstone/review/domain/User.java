package com.capstone.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

}
