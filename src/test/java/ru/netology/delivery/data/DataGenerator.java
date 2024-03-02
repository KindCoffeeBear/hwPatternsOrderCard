package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String[] cities;
        Random rnd = new Random();
        String city;

        if (locale.equals("ru")) {
            cities = new String[]{"Краснодар", "Мурманск", "Владикавказ",
                    "Казань", "Майкоп", "Майкоп", "Уфа", "Улан-Удэ", "Махачкала",
                    "Донецк", "Магас", "Нальчик", "Элиста", "Черкесск", "Петрозаводск",
                    "Сыктывкар", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ"};
            city = cities[rnd.nextInt(cities.length)];
        } else {
            city = "Введите город на русском языке";
        }

        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
