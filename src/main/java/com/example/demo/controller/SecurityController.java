package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("public/api")
    public String publicApi() {
        return "Сюда может зайти кто угодно!";
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/api")
    public String adminApi(Authentication authentication) {
        return "Админ " + authentication.getName() + " привет!";
    }

    @RolesAllowed("SUPPORT")
    @GetMapping("/support/api")
    public String supportApi(Authentication auth) {
        return "Привет, " + auth.getName() + ", это апи поддержки!";
    }


}
