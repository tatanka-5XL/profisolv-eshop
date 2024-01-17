package com.profisolv.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;

}

