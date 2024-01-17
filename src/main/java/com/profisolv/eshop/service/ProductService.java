package com.profisolv.eshop.service;

import com.profisolv.eshop.domain.Product;
import com.profisolv.eshop.model.ProductDto;
import com.profisolv.eshop.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto findProduct(Long id) {

        return productRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(()-> new EntityNotFoundException("Product " + id + " not found!"));
    }

    public Collection<ProductDto> findAllProducts() {

        return productRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductDto productDto) {

        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);

        return mapToDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {

        if(!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product " + id + " not found!");
        }

        Product product = mapToDomain(productDto);
        Product savedProduct = productRepository.save(product);

        return mapToDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getName() ,
                product.getDescription(),
                product.getImage(),
                product.getPrice(),
                product.getStock(),
                product.getId()
        );
    }

    private Product mapToDomain(ProductDto productDto) {
        return new Product()
                .setName(productDto.getName())
                .setDescription(productDto.getDescription())
                .setImage(productDto.getImage())
                .setPrice(productDto.getPrice())
                .setStock(productDto.getStock())
                .setId(productDto.getId());
    }


}
