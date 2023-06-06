package com.capstone.review.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id @GeneratedValue
//    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name= "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "roles")
    private String roles;

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}