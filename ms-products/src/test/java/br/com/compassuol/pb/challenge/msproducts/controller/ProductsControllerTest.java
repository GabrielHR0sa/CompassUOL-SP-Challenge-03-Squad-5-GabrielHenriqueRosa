package br.com.compassuol.pb.challenge.msproducts.controller;

import br.com.compassuol.pb.challenge.msproducts.dto.ProductsDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Category;
import br.com.compassuol.pb.challenge.msproducts.service.ProductsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @InjectMocks
    private ProductsController productsController;

    @Mock
    private ProductsService productsService;
    private ProductsDto responseProduct;

    private ProductsDto productsDto;

    @BeforeEach
    void setUp(){
        productsDto = new ProductsDto(1L,
                new Date(),
                "Teste",
                "Teste",
                "Teste.png",
                45.50F,
                Arrays.asList(new Category(1L, "teste", "teste")));
        responseProduct = productsService.getProductById(1L);
    }

    @Test
    void createProduct() {
        var response = assertDoesNotThrow(() -> productsController.createProduct(productsDto));
        assertEquals(productsController.createProduct(productsDto), response);
    }

    @Test
    void getProductById() {
        when(productsService.getProductById(1L)).thenReturn(responseProduct);
        var response = assertDoesNotThrow(() -> productsController.getProductById(1L));
        assertEquals(productsController.getProductById(1L),response);
    }

    @Test
    void getAllProducts() {
        var response = assertDoesNotThrow(() -> productsController.getAllProducts(0,5,"name", "ASC"));
        assertEquals(productsController.getAllProducts(0,5,"name", "ASC"), response);
    }

    @Test
    void deleteProductById() {
        var response = assertDoesNotThrow(() -> productsController.deleteProductById(1L));
        assertEquals(productsController.deleteProductById(1L), response);
    }

    @Test
    void updateProduct() {
        var response = assertDoesNotThrow(() -> productsController.updateProduct(productsDto, 1L));
        assertEquals(productsController.updateProduct(productsDto, 1L), response);
    }
}