package br.com.compassuol.pb.challenge.msproducts.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getId() {
        Role role = new Role();
        Long id = role.getId();
        assertNull(id);
    }

    @Test
    void getName() {
        Role role = new Role();
        String name = role.getName();
        assertNull(name);
    }

    @Test
    void setId() {
        Role role = new Role();
        Long newId = 1L;
        role.setId(newId);
        assertEquals(1L, newId);
    }

    @Test
    void setName() {
        Role role = new Role();
        String newName = "Teste";
        role.setName(newName);
        assertEquals("Teste", newName);
    }
}