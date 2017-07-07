package rest.library.test101.model;

/**
 * Created by Pankaj Nimgade on 7/5/2017.
 */
public class Response {

    private int responseCode;

    private String responseMessage;

    private Exception exception;

    public Response(int responseCode, String responseMessage, Exception exception) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.exception = exception;
    }

    public Response() {

    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "" + responseMessage;
    }
}
