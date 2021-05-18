package fr.esiea.ex4A.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserCountry {
    private final String code;

    private UserCountry(String code) {
        this.code = code;
    }

    @JsonCreator
    public static UserCountry fromString(String code) {
        if (code.matches("^[A-Z]{2}$")) {
            return new UserCountry(code);
        }

        return null;
    }

    @Override
    public String toString() {
        return code;
    }
}
