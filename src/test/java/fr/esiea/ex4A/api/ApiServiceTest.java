package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    void testRegister() throws Exception {
        var svc = apiService;

        var d = new InscriptionData("pierre@hubert.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        svc.register(d);

        var firstAgeCacheSize = svc.getAgeCache().size();
        assertThat(svc.getInscriptions().size()).isGreaterThan(0);
        assertThat(firstAgeCacheSize).isGreaterThan(0);

        svc.register(d);

        assertThat(svc.getAgeCache().size()).isEqualTo(firstAgeCacheSize);
    }

    @Test
    void testAge() throws Exception {
        var svc = apiService;

        var d = new InscriptionData("one@one.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        svc.register(d);

        var age = svc.getAge(d);
        assertThat(age).isBetween(40, 60);
    }

    @Test
    void testNoMatch() throws Exception {
        var svc = apiService;

        var d = new InscriptionData("pierre@hubert.fr", "Pierre", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        svc.register(d);

        var d2 = new InscriptionData("pierre@hubert.fr", "John", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        svc.register(d2);

        var list = svc.getMatches("Pierre", UserCountry.fromString("FR"));
        assertTrue(list.isEmpty());
    }

    @Test
    void testNoMatchNotRegistered() throws Exception {
        var svc = apiService;

        var list = svc.getMatches("Gerome", UserCountry.fromString("FR"));
        assertTrue(list.isEmpty());
    }

    @Test
    void testMatch() throws Exception {
        var svc = apiService;

        var d = new InscriptionData("pierre@hubert.fr", "berengere", "pierre",
            UserCountry.fromString("FR"), UserSex.F, UserSex.M);
        svc.register(d);

        var d2 = new InscriptionData("pierre@hubert.fr", "lea", "pierre",
            UserCountry.fromString("FR"), UserSex.M, UserSex.F);
        svc.register(d2);

        var list = svc.getMatches("lea", UserCountry.fromString("FR"));
        assertFalse(list.isEmpty());
    }

    @Test
    void testNoMatchInvalidPref() throws Exception {
        var svc = apiService;

        var d = new InscriptionData("pierre@hubert.fr", "berengere", "pierre",
            UserCountry.fromString("FR"), UserSex.F, UserSex.M);
        svc.register(d);

        var d2 = new InscriptionData("pierre@hubert.fr", "manon", "pierre",
            UserCountry.fromString("FR"), UserSex.F, UserSex.M);
        svc.register(d2);

        var list = svc.getMatches("manon", UserCountry.fromString("FR"));
        assertTrue(list.isEmpty());
    }
}
