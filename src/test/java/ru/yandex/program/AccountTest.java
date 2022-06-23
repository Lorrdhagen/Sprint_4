package ru.yandex.program;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {

    private String name;
    private boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные({index})")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Корбен Даллас", true},
                {"Ан", false},
                {"Равпекапрк Кавенроку", false},
                {"Больше Одного Пробела", false},
                {" Антонио Бандерос", false},
                {"Железный Человек ", false}
        };
    }

    @Test
    @DisplayName("Проверка имени")
    @Description("Одна проверка валидного имени + 5 проверок невалидных имен")
    public void checkNameToEmbossWithDifferentData() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }
}