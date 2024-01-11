package com.profisolv.eshop.service;

import com.profisolv.eshop.model.ProductDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    private Map<Long, ProductDto> productDtoMap;

    @PostConstruct
    public void init() {
         ProductDto productDto = new ProductDto(
                 "Dry PTFE Spray",
                 "Suché mazivo ve spreji",
                 "images/DryPTFESpray250x250.png",
                 100L,
                 10L,
                 1L
         );

        ProductDto productDto1 = new ProductDto(
                "Foam Cleaner",
                "Pěnový čistič ve spreji",
                "images/FoamCleaner250x250.png",
                50L,
                20L,
                2L
        );

        productDtoMap = Stream.of(productDto1, productDto)
                .collect(Collectors.toMap(
                        ProductDto::getId,
                        Function.identity()
                ));
    }

    public ProductDto findProduct(Long id) {

        return productDtoMap.get(id);
    }

    public Collection<ProductDto> findAllProducts() {

        return productDtoMap.values();
    }
}
