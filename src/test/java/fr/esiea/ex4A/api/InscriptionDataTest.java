package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscriptionDataTest {
    @Test
    void invalidData() {
        var d = new InscriptionData(null, null, null, null, null, null);
        assertFalse(d.isValid());
    }

    @Test
    void invalidEmail() {
        var d = new InscriptionData("", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        assertFalse(d.isValid());
    }

    @Test
    void invalidName() {
        var d = new InscriptionData("t@t.fr", "", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        assertFalse(d.isValid());
    }

    @Test
    void invalidTwitter() {
        var d = new InscriptionData("t@t.fr", "Pierre", "",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        assertFalse(d.isValid());
    }

    @Test
    void validData() {
        var d = new InscriptionData("pierre@hubert.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        assertTrue(d.isValid());
        assertEquals("pierre@hubert.fr", d.getUserEmail());
        assertEquals("Pierre", d.getUserName());
        assertEquals("pierre", d.getUserTweeter());
        assertEquals("FR", d.getUserCountry().toString());
        assertEquals(UserSex.M, d.getUserSex());
        assertEquals(UserSex.F, d.getUserSexPref());
    }

    @Test
    void validMatch() {
        var d = new InscriptionData("pierre@hubert.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F).toMatch();

        assertEquals("Pierre", d.getName());
        assertEquals("pierre", d.getTwitter());
    }

    @Test
    void validAgeRef() {
        var d = new InscriptionData("pierre@hubert.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F).toAgeReference();

        assertEquals("Pierre", d.getName());
        assertEquals("FR", d.getCountry());
    }
}
