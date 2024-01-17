package com.profisolv.eshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain=true)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
}
