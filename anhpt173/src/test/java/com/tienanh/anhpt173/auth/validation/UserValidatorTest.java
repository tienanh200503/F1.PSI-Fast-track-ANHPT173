package com.tienanh.anhpt173.auth.validation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserValidatorTest {

        private final UserValidator userValidator = new UserValidator();

    @Test
    void testValidEmail(){
        assertTrue(userValidator.isValidEmail("test@example.com"));
        assertFalse(userValidator.isValidEmail("test"));

    }

    @Test
    void testValidPassword(){
        assertTrue(userValidator.isValidPassword("123456789"));
        assertFalse(userValidator.isValidPassword("123"));
   }

}
