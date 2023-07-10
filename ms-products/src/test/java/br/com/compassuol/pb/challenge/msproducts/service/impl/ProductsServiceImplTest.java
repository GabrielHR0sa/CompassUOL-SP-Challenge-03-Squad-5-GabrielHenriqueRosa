package br.com.compassuol.pb.challenge.msproducts.service.impl;

import br.com.compassuol.pb.challenge.msproducts.dto.ProductsDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Category;
import br.com.compassuol.pb.challenge.msproducts.entity.Products;
import br.com.compassuol.pb.challenge.msproducts.repository.CategoryRepository;
import br.com.compassuol.pb.challenge.msproducts.repository.ProductsRepository;
import br.com.compassuol.pb.challenge.msproducts.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsServiceImplTest {

    @Mock
    private ProductsRepository productsRepository;
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductsService productsService = new ProductsServiceImpl(productsRepository, categoryRepository);

    private ProductsDto productsDto;


//    @Test
//    void createProduct() {
//        Products products = new Products(1L,
//                new Date(2023-07-07),
//                "Teste",
//                "Teste",
//                "Teste.png",
//                45.50F,
//                Arrays.asList(new Category(1L, "teste", "teste")));
//        when(productsRepository.save(any(Products.class))).thenReturn(products);
//        List<String> savedProduct = Collections.singletonList(productsService.createProduct((ProductsDto) new ProductsDto().getCategories()));
//        verify(productsRepository).save(any(Products.class));
//        assertThat(savedProduct).isNotNull();
//
//    }

    @Test
    void getProductById() {
        Products products = new Products(1L,
                new Date(2023 - 07 - 07),
                "Teste",
                "Teste",
                "Teste.png",
                45.50F,
                Arrays.asList(new Category(1L, "teste", "teste")));
        when(productsRepository.findById(1L)).thenReturn(Optional.of(products));
        ProductsDto foundProducts = productsService.getProductById(1L);
        verify(productsRepository).findById(1L);
    }

    @Test
    void getAllProducts() {

    }

    @Test
    void deleteProductById() {

    }

    @Test
    void updateProduct() {
    }
}