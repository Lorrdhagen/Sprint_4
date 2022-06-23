package ru.yandex.program;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Проверить имя")
    public boolean checkNameToEmboss() {

        int spaceCount = StringUtils.countMatches(name, " ");

        if (name.length() < 3) {
            return false;
        } else if (name.length() > 19) {
            return false;
        } else if (spaceCount > 1) {
            return false;
        } else if (name.startsWith(" ")) {
            return false;
        } else if (name.endsWith(" ")) {
            return false;
        }
        return true;
    }
}
