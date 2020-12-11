package com.example.demo.controllers;

import java.util.Map;

import com.example.demo.domains.MenuDTO;
import com.example.demo.services.MenuService;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuControllers {
    @Autowired Proxy px;
    @Autowired MenuService menuService;

    @PostMapping("/menu")
    public Map<?,?> register(@RequestBody MenuDTO menu){
        var map = px.hashmap();
        map.put("message", px.message(menuService.register(menu)));
        return map;
    }

    @GetMapping("/menu/crawling/{category}")
    public Map<?,?> crawling(@PathVariable String category){
        var map = px.hashmap();
        switch(category){
            case "living":
            map.put("living", menuService.crawling("https://www.jigushop.co.kr/50"));
            case "kitchen":
            map.put("kitchen", menuService.crawling("https://www.jigushop.co.kr/48"));
            case "drinkware":
            map.put("drinkware", menuService.crawling("https://www.jigushop.co.kr/176"));
            case "stationary":
            map.put("stationary", menuService.crawling("https://www.jigushop.co.kr/51"));
            break;
        }
        return map;
    }
}
