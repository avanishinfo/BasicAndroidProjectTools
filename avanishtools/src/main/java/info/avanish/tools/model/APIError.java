package info.avanish.tools.model;

/**
 * Created by Avanish Singh on 23-07-2017.
 */

public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}