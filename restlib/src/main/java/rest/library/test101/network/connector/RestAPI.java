package rest.library.test101.network.connector;

import java.net.URL;

import rest.library.test101.model.Parameters;
import rest.library.test101.model.Response;

/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */
public abstract class RestAPI {

    private static boolean isTidAvailable = false;
    private static Parameters.Parameter tidParameter;
    protected URL url;
    protected static final String newLine = System.getProperty("line.separator");


    public abstract Response callRequest(Request request) throws Exception;

    public static void setIsTidAvailable(boolean isTidAvailable) {
        RestAPI.isTidAvailable = isTidAvailable;
    }

    public static boolean isTidAvailable() {
        return isTidAvailable;
    }

    public static void setTidParameter(Parameters.Parameter tidParameter) {
        RestAPI.tidParameter = tidParameter;
    }

    public static Parameters.Parameter getTidParameter() {
        return tidParameter;
    }
}
