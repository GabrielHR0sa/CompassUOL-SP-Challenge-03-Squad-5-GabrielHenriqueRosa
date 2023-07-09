package br.com.compassuol.pb.challenge.msproducts.entity;

import br.com.compassuol.pb.challenge.msproducts.repository.CategoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getCategoryId() {
        Category category = new Category();
        Long categoryId = category.getCategoryId();
        assertNull(categoryId);
    }

    @Test
    void getName() {
        Category category = new Category();
        String name = category.getName();
        assertNull(name);
    }

    @Test
    void getDescription() {
        Category category = new Category();
        String description = category.getDescription();
        assertNull(description);
    }

    @Test
    void setCategoryId() {
        Category category = new Category();
        Long newCategoryId = 1L;
        category.setCategoryId(newCategoryId);
        assertEquals(1L, newCategoryId);
    }

    @Test
    void setName() {
        Category category = new Category();
        String newName = "Teste";
        category.setName(newName);
        assertEquals("Teste", newName);
    }

    @Test
    void setDescription() {
        Category category = new Category();
        String newDescription = "Teste";
        category.setDescription(newDescription);
        assertEquals("Teste", newDescription);
    }
}