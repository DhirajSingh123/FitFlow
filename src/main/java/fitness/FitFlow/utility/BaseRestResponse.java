package fitness.FitFlow.utility;

import org.springframework.stereotype.Component;

public class BaseRestResponse<T> {
    private String status;
    private String message;
    private Integer statusCode;
    private T data;

    public BaseRestResponse() {
    }

    public BaseRestResponse(String status, String message,Integer statusCode, T data) {
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BaseRestResponse<T> success(T data) {
        return new BaseRestResponse<>("SUCCESS", "Request was successful", 200, data);
    }

    public static <T> BaseRestResponse<T> failure(String message) {
        return new BaseRestResponse<>("FAILED", message, 400, null);
    }
}