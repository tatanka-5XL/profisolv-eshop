package com.profisolv.eshop.rest;

import com.profisolv.eshop.model.ProductDto;
import com.profisolv.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ProductDto findProduct(@PathVariable("id") Long id) {
        return productService.findProduct(id);
    }

    @GetMapping("/")
    public Collection<ProductDto> findAllProducts() {
        return productService.findAllProducts();
    }

}
