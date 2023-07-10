package br.com.compassuol.pb.challenge.msproducts.controller;

import br.com.compassuol.pb.challenge.msproducts.dto.CategoryDto;
import br.com.compassuol.pb.challenge.msproducts.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;
    private CategoryDto responseCategory;

    private CategoryDto categoryDto;

    @BeforeEach
    void setUp() {
        categoryDto = new CategoryDto(1L, "Teste", "Teste");
        responseCategory = categoryService.getCategory(1L);
    }

    @Test
    void addCategory() {
        var response = assertDoesNotThrow(() -> categoryController.addCategory(categoryDto));
        assertEquals(categoryController.addCategory(categoryDto), response);
    }

    @Test
    void getCategory() {
        when(categoryService.getCategory(1L)).thenReturn(responseCategory);
        var response = assertDoesNotThrow(() -> categoryController.getCategory(1L));
        assertEquals(categoryController.getCategory(1L), response);
    }

    @Test
    void updateCategory() {
        var response = assertDoesNotThrow(() -> categoryController.updateCategory(categoryDto, 1L));
        assertEquals(categoryController.updateCategory(categoryDto, 1L), response);
    }

    @Test
    void deleteCategory() {
        var response = assertDoesNotThrow(() -> categoryController.deleteCategory(1L));
        assertEquals(categoryController.deleteCategory(1L), response);
    }
}