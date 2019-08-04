package info.avanish.tools.api;

/**
 * Created by Avanish Singh on 25/02/18.
 */

public class ApiResponse {

    private String details;
    private boolean success;
    private String message;
    private String errorMessage;
    private int status;
    private int otp;
    private String other;


    public String getDetails() {
        return details;
    }

    public void setDetails(String mDetails) {
        details = mDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int code) {
        this.status = code;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int code) {
        this.otp = code;
    }

}
