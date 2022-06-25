package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NUMBER_PHONE_REGEX = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
            + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
    public static final String NUMBER_REGEX = "\\d+";

    public static final String LETTER_WITHOUT_NUMBER_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String EMAIL_REGEX = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";
    public static final String DATE_REGEX = "[0-9]{4}-([0-9]|0[0-9]1[0-2])-([0-9]|[0-2][0-9]|3[0-1])$";
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
    public static final String PASSWORD_REGEX = "([\\d\\s\\w!@#$%^&*+_=]{6,})";

    public static boolean isPasswordVailid(String pass) {
        return Pattern.compile(PASSWORD_REGEX).matcher(pass).matches();
    }

    public static boolean isNumberPhoneVailid(String number) {
        return Pattern.compile(NUMBER_PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isUserNameVailid(String username) {
        return Pattern.compile(USERNAME_REGEX).matcher(username).matches();
    }

    public static boolean isNumberVailid(String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).matches();
    }

    public static boolean isLetterWithoutNumberValid(String name) {
        return Pattern.compile(LETTER_WITHOUT_NUMBER_REGEX).matcher(name).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean isDateValid(String dateStr) {
        return Pattern.compile(DATE_REGEX).matcher(dateStr).matches();
    }
}
