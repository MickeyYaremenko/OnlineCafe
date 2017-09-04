package by.htp.onlinecafe.util;

import java.util.regex.Pattern;

/**
 * The class {@link Validator} checks necessary input data
 */
public final class Validator {

    private Validator(){}

    private static final String NUMBERS_WITH_DELIMITER_REGEX = "^[0-9]*\\.?[0-9]+$";
    private static final String EMAIL_REGEX = "[A-z0-9_\\.-]+@[A-z0-9.-]+\\.[a-z]{2,6}";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{3,}$";
    private static final String LOGIN_REGEX = "[A-z0-9_-]{3,10}";

    /**
     * Checks the given string for matching with
     * the {@link Validator#EMAIL_REGEX} pattern
     * and that this string is not null
     * @param email string which represents the email
     */
    public static Boolean checkEmail(String email){
        if (null != email){
            return Pattern.matches(EMAIL_REGEX, email);
        }
        return Boolean.FALSE;
    }

    /**
     * Checks the given string for matching with
     * the {@link Validator#NUMBERS_WITH_DELIMITER_REGEX} pattern
     * and that this string is not null
     * @param number string which represents the email
     */
    public static Boolean checkNumbersWithDelimiter(String number){
        if (null != number){
            return Pattern.matches(NUMBERS_WITH_DELIMITER_REGEX, number);
        }
        return Boolean.FALSE;
    }

    /**
     * Checks the given string for matching with
     * the {@link Validator#PASSWORD_REGEX} pattern
     * and that this string is not null
     * @param password string which represents the email
     */
    public static Boolean checkPassword(String password){
        if (null != password){
            return Pattern.matches(PASSWORD_REGEX, password);
        }
        return Boolean.FALSE;
    }

    /**
     * Checks the given string for matching with
     * the {@link Validator#LOGIN_REGEX} pattern
     * and that this string is not null
     * @param login string which represents the email
     */
    public static Boolean checkLogin(String login){
        if (null != login){
            return Pattern.matches(LOGIN_REGEX, login);
        }
        return Boolean.FALSE;
    }

}
