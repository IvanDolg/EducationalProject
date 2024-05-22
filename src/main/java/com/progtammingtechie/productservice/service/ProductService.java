package com.progtammingtechie.productservice.service;

import com.progtammingtechie.productservice.dto.ProductRequest;
import com.progtammingtechie.productservice.dto.ProductResponse;
import com.progtammingtechie.productservice.model.Product;
import com.progtammingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .description(productRequest.getDescription())
                .name(productRequest.getName())
                .price(productRequest.getPrice()) 
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                 .id(product.getId())
                 .name(product.getName())
                 .description(product.getDescription())
                 .price(product.getPrice())
                 .build();
    }
}
