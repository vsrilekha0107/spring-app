package com.eg.spring_app;

import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api")
public class DataController {
 
    @GetMapping("/validate")
    public boolean validate(
            @RequestParam String attr,
            @RequestParam String value,
            @RequestParam String operator) {
 
        Data derivedData = new Data();
        derivedData.init();
        return derivedData.validateOperator(attr, value, operator);
    }
}