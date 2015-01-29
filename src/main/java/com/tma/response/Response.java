package com.tma.response;

public class Response  {
	private String statusCode;
	private String status;
	private String message;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", status=" + status
				+ ", message=" + message + "]";
	}

	public Response() {
	}

	/**
	 * @param statusCode
	 * @param status
	 * @param message
	 */
	public Response(String statusCode, String status, String message) {
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
	}
	
	
}
