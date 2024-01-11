package com.profisolv.eshop.model;

public class ProductDTO {

    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;

    public ProductDTO(String name, String description, String image, Long price, Long stock, Long id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Long getPrice() {
        return price;
    }

    public Long getStock() {
        return stock;
    }

    public Long getId() {
        return id;
    }
}

