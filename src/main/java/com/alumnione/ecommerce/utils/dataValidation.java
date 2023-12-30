package com.alumnione.ecommerce.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class dataValidation {
    public static boolean validationMethod(String patternType, String dataToMatch) {
        Pattern pattern = Pattern.compile(patternType);
        Matcher matcher = pattern.matcher(dataToMatch);
        return matcher.matches();

    }
}
