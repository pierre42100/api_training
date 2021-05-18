package fr.esiea.ex4A.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserSex {
    M,
    F,
    O;

    @Override
    public String toString() {
        return switch (this) {
            case M -> "M";
            case F -> "F";
            default -> "O";
        };
    }

    @JsonCreator
    public static UserSex fromText(String text) {
        return switch (text) {
            case "M" -> UserSex.M;
            case "F" -> UserSex.F;
            case "O" -> UserSex.O;
            default -> null;
        };
    }
}
