package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UserCountryTest {
    @Test
    void simple() {
        var c =  UserCountry.fromString("FR");

        assertEquals("FR", Objects.requireNonNull(c).toString());
    }

    @Test
    void invalid() {
        var c =  UserCountry.fromString("FRANCE");

        assertNull(c);
    }
}
