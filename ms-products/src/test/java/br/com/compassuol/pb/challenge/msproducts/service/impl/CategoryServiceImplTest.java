package br.com.compassuol.pb.challenge.msproducts.service.impl;

import br.com.compassuol.pb.challenge.msproducts.dto.CategoryDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Category;
import br.com.compassuol.pb.challenge.msproducts.repository.CategoryRepository;
import br.com.compassuol.pb.challenge.msproducts.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService = new CategoryServiceImpl(categoryRepository);

    @Test
    void createCategory() {
        Category category = new Category();
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        CategoryDto saveCategory = categoryService.createCategory(new CategoryDto());
        verify(categoryRepository).save(any(Category.class));
        assertThat(saveCategory).isNotNull();
    }

    @Test
    void getCategory() {
        Category category = new Category();
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        CategoryDto foundCategory = categoryService.getCategory(1L);
        assertThat(foundCategory).isNotNull();
        verify(categoryRepository).findById(1L);
    }

    @Test
    void getAllCategories() {

        List<Category> category = Arrays.asList(
                new Category(1L, "Teste 1", "descrição teste 1"),
                new Category(2L, "Teste 2", "descrição teste 2")
        );

        when(categoryRepository.findAll()).thenReturn(category);
        List<CategoryDto> listCategory = categoryService.getAllCategories();

        assertEquals("Teste 1", listCategory.get(0).getName());
        assertEquals("Teste 2", listCategory.get(1).getName());

        assertEquals("descrição teste 1", listCategory.get(0).getDescription());
        assertEquals("descrição teste 2", listCategory.get(1).getDescription());
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }
}