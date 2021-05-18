package fr.esiea.ex4A.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InscriptionData {
    private final String userEmail;
    private final String userName;
    private final String userTweeter;
    private final UserCountry userCountry;
    private final UserSex userSex;
    private final UserSex userSexPref;

    @JsonCreator
    public InscriptionData(@JsonProperty("userEmail") String userEmail, @JsonProperty("userName") String userName,
                           @JsonProperty("userTweeter")  String userTweeter,
                           @JsonProperty("userCountry")  UserCountry userCountry,
                           @JsonProperty("userSex")  UserSex userSex,
                           @JsonProperty("userSexPref")  UserSex userSexPref) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }

    boolean isValid() {
        return userEmail != null &&
            !userEmail.isBlank() &&
            userName != null &&
            !userName.isBlank() &&
            userTweeter != null &&
            !userTweeter.isBlank() &&
            userCountry != null &&
            userSex != null &&
            userSexPref != null;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public UserCountry getUserCountry() {
        return userCountry;
    }

    public UserSex getUserSex() {
        return userSex;
    }

    public UserSex getUserSexPref() {
        return userSexPref;
    }

    public MatchData toMatch() {
        return new MatchData(userName, userTweeter);
    }
}
