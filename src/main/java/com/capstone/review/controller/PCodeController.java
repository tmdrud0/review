package com.capstone.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;


public class PCodeController {
    @PostMapping("/api/savePCode")
    @ResponseBody
    public ResponseEntity<String> savePCode(@RequestBody String pcode) {
        try {
            FileWriter fileWriter = new FileWriter("static/json/product.json");
            fileWriter.write(pcode);
            fileWriter.close();

            // 리다이렉션
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/reviewResult")
                    .body("Redirecting to /reviewResult");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("pcode 저장 중 오류가 발생하였습니다.");
        }
    }
}