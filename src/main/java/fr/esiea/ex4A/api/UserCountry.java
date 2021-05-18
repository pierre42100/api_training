package fr.esiea.ex4A.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserCountry {
    private String code;

    @JsonCreator
    public static UserCountry fromString(String code) {
        if (code.matches("^[A-Z]{2}$")) {
            UserCountry userCountry = new UserCountry();
            userCountry.code = code;
            return userCountry;
        }

        return null;
    }

    @Override
    public String toString() {
        return code;
    }
}
