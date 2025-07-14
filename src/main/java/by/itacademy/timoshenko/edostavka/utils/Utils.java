package by.itacademy.timoshenko.edostavka.utils;

import java.util.Random;

public class Utils {


    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        String[] operatorCodes = {"25", "29", "33", "44"};
        String operatorCode = operatorCodes[random.nextInt(operatorCodes.length)];
        int uniquePart = random.nextInt(1_000_000, 10_000_000);
        return String.format("+375 %s %03d-%02d-%02d",
                operatorCode,
                uniquePart / 10000,
                (uniquePart / 100) % 100,
                uniquePart % 100);
    }
}
