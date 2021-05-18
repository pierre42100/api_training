package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSexTest {
    @Test
    void fromText() {
        assertEquals(UserSex.M, UserSex.fromText("M"));
        assertEquals(UserSex.F, UserSex.fromText("F"));
        assertEquals(UserSex.O, UserSex.fromText("O"));
    }

    @Test
    void fromTextInvalid() {
        assertNull(UserSex.fromText("toto"));
    }

    @Test
    void testToString() {
        assertEquals("M", UserSex.M.toString());
        assertEquals("F", UserSex.F.toString());
        assertEquals("O", UserSex.O.toString());
    }
}
