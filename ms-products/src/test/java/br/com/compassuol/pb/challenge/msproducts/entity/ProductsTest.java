package br.com.compassuol.pb.challenge.msproducts.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    @Test
    void getProductId() {
        Products products = new Products();
        Long productId = products.getProductId();
        assertNull(productId);
    }

    @Test
    void getDateT() {
        Products products = new Products();
        Date dateT = products.getDateT();
        assertNull(dateT);
    }

    @Test
    void getDescription() {
        Products products = new Products();
        String description = products.getDescription();
        assertNull(description);
    }

    @Test
    void getName() {
        Products products = new Products();
        String name = products.getName();
        assertNull(name);
    }

    @Test
    void getImgURL() {
        Products products = new Products();
        String imgURL = products.getImgURL();
        assertNull(imgURL);
    }

    @Test
    void getPrice() {
        Products products = new Products();
        float price = products.getPrice();
        assertEquals(0.0, price);
    }

    @Test
    void getCategories() {
        Products products = new Products();
        List<Category> categories = products.getCategories();
        assertNull(categories);
    }

    @Test
    void setProductId() {
        Products products = new Products();
        Long newProductId = 1L;
        products.setProductId(newProductId);
        assertEquals(1L, newProductId);
    }

    @Test
    void setDescription() {
        Products products = new Products();
        String newDescription = "Teste";
        products.setDescription(newDescription);
        assertEquals("Teste", newDescription);
    }

    @Test
    void setName() {
        Products products = new Products();
        String newName = "Teste";
        products.setName(newName);
        assertEquals("Teste", newName);
    }

    @Test
    void setImgURL() {
        Products products = new Products();
        String newImgURL = "img.png";
        products.setImgURL(newImgURL);
        assertEquals("img.png", newImgURL);
    }

    @Test
    void setPrice() {
        Products products = new Products();
        float newPrice = 79.9F;
        products.setPrice(newPrice);
        assertEquals(79.9F, newPrice);
    }
}