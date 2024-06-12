package com.sparta.junit5practice.controller;


import com.sparta.junit5practice.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get 메소드 호출");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @PostMapping("/post")
    public void post(@RequestBody User user) {
        System.out.println("post 메소드 호출");
        System.out.println("user = " + user);
    }
}
