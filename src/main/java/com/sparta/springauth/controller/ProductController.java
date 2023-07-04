package com.sparta.springauth.controller;

import com.sparta.springauth.dto.ProductRequestDto;
import com.sparta.springauth.entity.User;
import com.sparta.springauth.entity.UserRoleEnum;
import com.sparta.springauth.security.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        //Authentication 의 Principle
        User user = userDetails.getUser();
        System.out.println("user.getUsername() = " + user.getUsername());
        System.out.println("user.getEmail() = " + user.getEmail());

        return "redirect:/";
    }
    @Secured(UserRoleEnum.Authority.ADMIN) // 관리자용
    @GetMapping("/products/secured")
    public String getProductsByAdmin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            System.out.println("authority.getAuthority() = " + authority.getAuthority());
        }

        return "redirect:/";
    }

    @PostMapping("/validation")
    @ResponseBody
    public ProductRequestDto testValid(@RequestBody @Valid ProductRequestDto requestDto) {
        return requestDto;
    }
}