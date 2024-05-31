package br.com.blooddonors.domain.exception.details;

public class ExceptionDetails {


    private String timestamp;

    private Integer statusCode;

    private String error;

    private String path;

    public ExceptionDetails() {
    }

    public ExceptionDetails(String timestamp, Integer statusCode, String error, String path) {
	this.timestamp = timestamp;
	this.statusCode = statusCode;
	this.error = error;
	this.path = path;
    }

    public String getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
    }

    public String getError() {
	return error;
    }

    public void setError(String error) {
	this.error = error;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }
}
