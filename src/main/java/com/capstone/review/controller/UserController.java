package com.capstone.review.controller;

import com.capstone.review.config.JwtTokenProvider;
import com.capstone.review.domain.User;
import com.capstone.review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    final String NAME = "ddd";
    final Long SEQUENCEID = Long.valueOf(1);

    User user = User.builder()
            .name(NAME)
            .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
            .build();


    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "users/login";
    }

    // 로그인
    @PostMapping("/login")
    @Transactional
    public String login(@ModelAttribute("userForm") UserForm userForm, BindingResult result) {
        User user = userRepository.findByName(userForm.getName()).get(0);
        if(user==null)      return "users/login";
        return "redirect:/";
    }
    @PostMapping("/users/new")
    @Transactional
    public String create(@ModelAttribute("userForm") UserForm userForm, BindingResult result) {

        if (result.hasErrors()) {
            return "users/createUserForm";
        }
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/users/new")
    public String createForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "users/createUserForm";
    }
}