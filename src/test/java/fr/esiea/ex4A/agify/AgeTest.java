package fr.esiea.ex4A.agify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeTest {

    @Test
    void simple() {
        Age age = new Age("Pierre", 20, 1000, "FR");
        assertEquals(age.getName(), "Pierre");
        assertEquals(age.getAge(), 20);
        assertEquals(age.getCount(), 1000);
        assertEquals(age.getCountryId(), "FR");
    }
}
