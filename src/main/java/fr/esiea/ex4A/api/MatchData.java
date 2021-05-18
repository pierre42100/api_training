package fr.esiea.ex4A.api;

public class MatchData {
    private final String name;
    private final String twitter;

    public MatchData(String name, String twitter) {
        this.name = name;
        this.twitter = twitter;
    }

    public String getName() {
        return name;
    }

    public String getTwitter() {
        return twitter;
    }
}
