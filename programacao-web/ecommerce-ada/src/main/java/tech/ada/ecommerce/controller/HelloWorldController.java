package tech.ada.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {


    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello, World!");
        return "Olá, Mundo!";
    }

}
