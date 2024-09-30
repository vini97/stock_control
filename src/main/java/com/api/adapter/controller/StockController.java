package com.api.adapter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class StockController {
    
    @PostMapping("/create")
    public void CreateItem(@RequestBody String request){
        System.out.println(request);
    }
}
