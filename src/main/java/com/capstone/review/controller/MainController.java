package com.capstone.review.controller;

import com.capstone.review.DTO.Form;
import com.capstone.review.entity.ProductName;
import com.capstone.review.repository.PdnameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@Slf4j // 로깅 annotation
public class MainController {
    @Autowired // spring boot가 미리 생성해놓은 객체 가져다 자동 연결
    private PdnameRepository pdnameRepository;

    @GetMapping("/main")
    public String formData(){

        return "/review/main";
    }
    @GetMapping("/showReview")
    public String link1(){
        return "/review/reviewResult";
    }

    @GetMapping("/showCompareList")
    public String link2(){
        return "/review/comparelist";
    }

    @GetMapping("/showCompareResult")
    public String link3(){
        return "/review/compare";
    }

    @PostMapping("/search")
    public String createData(Form form){ //container
        log.info(form.toString());

        // Dto를 entity로 변환
        ProductName pdName = form.toEntity();
        log.info(pdName.toString());

        // repository에 entity를 db로 저장하게 함
        ProductName saved = pdnameRepository.save(pdName);
        log.info(saved.toString());

        return "redirect:/result";
    }
    @GetMapping("/result")
    public String show(Model model){

        // 1. 모든 데이터 가져오기
        List<ProductName> pdNameEntity = pdnameRepository.findAll();

        // 2. 가져온 데이터 묶음 view 전달
        model.addAttribute("pdNameList", pdNameEntity);

        // 3. 뷰 페이지 설정
        return "/review/showlist";

    }
}
