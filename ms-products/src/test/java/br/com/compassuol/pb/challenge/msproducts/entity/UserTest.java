package br.com.compassuol.pb.challenge.msproducts.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        User user = new User();
        Long id = user.getId();
        assertNull(id);
    }

    @Test
    void getFirstName() {
        User user = new User();
        String firstName = user.getFirstName();
        assertNull(firstName);

    }

    @Test
    void getLastName() {
        User user = new User();
        String lastName = user.getLastName();
        assertNull(lastName);
    }

    @Test
    void getEmail() {
        User user = new User();
        String email = user.getEmail();
        assertNull(email);
    }

    @Test
    void getPassword() {
        User user = new User();
        String password = user.getPassword();
        assertNull(password);
    }

    @Test
    void getRoles() {
        User user = new User();
        Set<Role> roles = user.getRoles();
        assertNull(roles);
    }

    @Test
    void setId() {
        User user = new User();
        Long newId = 1L;
        user.setId(newId);
        assertEquals(1,user.getId());
    }

    @Test
    void setFirstName() {
        User user = new User();
        String newFirstName = "Gabriel";
        user.setFirstName(newFirstName);
        assertEquals("Gabriel", newFirstName);
    }

    @Test
    void setLastName() {
        User user = new User();
        String newLastName = "Rosa";
        user.setFirstName(newLastName);
        assertEquals("Rosa", newLastName);
    }

    @Test
    void setEmail() {
        User user = new User();
        String newEmail = "gabriel@gmail.com";
        user.setEmail(newEmail);
        assertEquals("gabriel@gmail.com", newEmail);
    }

    @Test
    void setPassword() {
        User user = new User();
        String newPassword = "123";
        user.setPassword(newPassword);
        assertEquals("123", newPassword);
    }

}