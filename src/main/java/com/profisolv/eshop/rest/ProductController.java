package com.profisolv.eshop.rest;

import com.profisolv.eshop.model.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/v1/product")
    public ProductDTO findProduct() {
        return new ProductDTO(
                "Dry PTFE Spray",
                "Suché mazivo ve spreji",
                "images/DryPTFESpray250x250.png",
                100L,
                10L,
                1L
        );
    }
}
