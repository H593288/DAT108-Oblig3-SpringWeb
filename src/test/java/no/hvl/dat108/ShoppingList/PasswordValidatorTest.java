package no.hvl.dat108.ShoppingList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import no.hvl.dat108.ShoppingList.Util.PasswordValidator;

public class PasswordValidatorTest {

    @Test
    public void validPasswordSpecialCharacterAllowed() {
        assertTrue(PasswordValidator.isPasswordValid("!@#$&"));
    }

    @Test
    public void norwegianLettersAllowed() {
        assertTrue(PasswordValidator.isPasswordValid("øæåØÆÅ"));
    }

    @Test
    public void passwordLengthTooLong() {
        String password = "Abcdefg5#abcdefgabcd";
        boolean actual = PasswordValidator.isPasswordValid(password);
        assertFalse(actual);
    }

    @Test
    public void passwordNull() {
        assertFalse(PasswordValidator.isPasswordValid(null));
    }
}
