package com.capstone.review.controller;

import com.capstone.review.domain.User;
import com.capstone.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/member/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/user/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        User user = new User();
        user.setName(form.getName());

        userService.join(user);
        return "redirect:/";
    }

    @GetMapping("/user")
    public String list(Model model) {
        List<User> users = userService.findMembers();
        model.addAttribute("members", users);
        return "members/memberList";
    }
}