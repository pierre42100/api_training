package fr.esiea.ex4A.api;

public class InscriptionData {
    private String userEmail;
    private String userName;
    private String userTweeter;
    private UserCountry userCountry;
    private UserSex userSex;
    private UserSex userSexPref;

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

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public void setUserTweeter(String userTweeter) {
        this.userTweeter = userTweeter;
    }

    public UserCountry getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(UserCountry userCountry) {
        this.userCountry = userCountry;
    }

    public UserSex getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    public UserSex getUserSexPref() {
        return userSexPref;
    }

    public void setUserSexPref(UserSex userSexPref) {
        this.userSexPref = userSexPref;
    }
}
