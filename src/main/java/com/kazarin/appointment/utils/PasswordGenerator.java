package com.kazarin.appointment.utils;

import com.kazarin.appointment.config.Sha256PasswordEncoder;
import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {

    public static String generatePassword() {
//        return new RandomStringUtils().nextAscii(8);
        return "12345";
    }

    public static String encodePassword(String rawPassword) {
        return new Sha256PasswordEncoder().encode(rawPassword);
    }
}
