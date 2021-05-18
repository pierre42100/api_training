package fr.esiea.ex4A.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchDataTest {

    @Test
    void simple() {
        var matchData = new MatchData("pierre", "tweet");

        assertEquals("pierre", matchData.getName());
        assertEquals("tweet", matchData.getTwitter());
    }
}
