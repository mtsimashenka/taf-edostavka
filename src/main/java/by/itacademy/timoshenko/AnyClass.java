package by.itacademy.timoshenko;

import by.itacademy.timoshenko.edostavka.utils.Utils;

public class AnyClass {
    public static void main(String[] args) {
        String randomPhone = Utils.generateRandomPhoneNumber();
        System.out.println("Сгенерированный номер телефона: " + randomPhone);
    }
}
