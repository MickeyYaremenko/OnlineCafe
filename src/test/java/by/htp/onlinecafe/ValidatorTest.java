package by.htp.onlinecafe;

import by.htp.onlinecafe.util.Validator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void checkEmail() {
        String email = "oneone@gmail.com";
        Assert.assertTrue(Validator.checkEmail(email));
        email = "one_two-three@mail.ru";
        Assert.assertTrue(Validator.checkEmail(email));
        email = "oneonemail.ru";
        Assert.assertFalse(Validator.checkEmail(email));
    }

    @Test
    public void checkNumbersWithDelimiter() {
        String number = "15";
        Assert.assertTrue(Validator.checkNumbersWithDelimiter(number));
        number = "18.5";
        Assert.assertTrue(Validator.checkNumbersWithDelimiter(number));
        number = "19,4";
        Assert.assertFalse(Validator.checkNumbersWithDelimiter(number));
    }

    @Test
    public void checkPassword() {
        String password = "Qwerty123";
        Assert.assertTrue(Validator.checkPassword(password));
        password = "123qweRTY";
        Assert.assertTrue(Validator.checkPassword(password));
        password = "qwerty";
        Assert.assertFalse(Validator.checkPassword(password));
    }

    @Test
    public void checkLogin() {
        String login = "wsx123";
        Assert.assertTrue(Validator.checkLogin(login));
        login = "QAZwsx";
        Assert.assertTrue(Validator.checkLogin(login));
        login = "qa";
        Assert.assertFalse(Validator.checkLogin(login));
    }
}
