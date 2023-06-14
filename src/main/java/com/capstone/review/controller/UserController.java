package com.capstone.review.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/login_page")
    public String login_page() {
        return "login_page";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/user-test")
    public String test() {
        return "test";
    }

}