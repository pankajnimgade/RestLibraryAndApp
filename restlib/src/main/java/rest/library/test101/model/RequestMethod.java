package rest.library.test101.model;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public enum RequestMethod {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    COPY("COPY"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    LINK("LINK"),
    UNLINK("UNLINK"),
    PURGE("PURGE"),
    LOCK("LOCK"),
    UNLOCK("UNLOCK"),
    PROPFIND("PROPFIND"),
    VIEW("VIEW");

    private String requestMethod;

    RequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }
}
