package com.sparta.springauth.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ProductRequestDto {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Positive(message = "양수만 가능합니다.")
    private int price;
    @Negative(message = "음수만 가능합니다.")
    private int discount;
    @Size(min=2, max=10)
    private String link;
    @Max(10)
    private int max;
    @Min(2)
    private int min;
}