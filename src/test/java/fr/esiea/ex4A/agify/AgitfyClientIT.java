package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.Launcher;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgitfyClientIT {
    private final  AgifyClient client = Launcher.buildAgifyClient();

    @Test
    void testMichaelUS() throws Exception{
        var age = client.getAge("michael", "US").execute().body();

        assertThat(age).isNotNull();

        assertThat(age.getAge()).isBetween(60, 80);
        assertThat(age.getCount()).isGreaterThanOrEqualTo(875);
        assertThat(age.getName()).isEqualTo("michael");
        assertThat(age.getCountryId()).isEqualTo("US");
    }
}
