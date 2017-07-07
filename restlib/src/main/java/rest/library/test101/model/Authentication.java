package rest.library.test101.model;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public enum Authentication {

    NO_AUTHENTICATION("NO_AUTHENTICATION"),
    AUTHENTICATION_OAUTH_1_01_A("OAUTH_1.01A"),
    AUTHENTICATION_OAUTH_2("OAUTH_2");

    private String authentication;

    Authentication(String authentication) {
        this.authentication = authentication;
    }

    public String getAuthentication() {
        return authentication;
    }


}
