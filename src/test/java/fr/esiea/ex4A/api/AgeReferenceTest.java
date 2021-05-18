package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AgeReferenceTest {

    @Test
    void first() {
        var ageReference = new AgeReference("Pierre",
            Objects.requireNonNull(UserCountry.fromString("FR")));

        assertEquals(ageReference.getCountry(), "FR");
        assertEquals("Pierre", ageReference.getName());
    }

    @Test
    void testEqualsOne() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        assertEquals(one, one);
    }

    @Test
    void testEqualsTwo() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        var two = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));

        assertEquals(one, two);
    }

    @Test
    void testDifferentCountry() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        var two = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("US")));

        assertNotEquals(one, two);
        assertNotEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void testDifferentNull() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));

        assertNotEquals(one, null);
    }

    @Test
    void testDifferentOtherObject() {
        Object one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        Object two = new Object();

        assertNotEquals(one, two);
        assertNotEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void testDifferentName() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        var two = new AgeReference("Benoit", Objects.requireNonNull(UserCountry.fromString("FR")));

        assertNotEquals(one, two);
        assertNotEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void testDifferentNameAndCountry() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        var two = new AgeReference("John", Objects.requireNonNull(UserCountry.fromString("US")));

        assertNotEquals(one, two);
        assertNotEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void testHashTwo() {
        var one = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));
        var two = new AgeReference("Pierre", Objects.requireNonNull(UserCountry.fromString("FR")));

        assertEquals(one.hashCode(), two.hashCode());
    }
}
