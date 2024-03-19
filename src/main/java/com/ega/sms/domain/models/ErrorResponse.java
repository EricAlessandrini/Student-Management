package com.ega.sms.domain.models;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

	private String code;
	private String message;
	private List<String> details;
	private LocalDateTime timestamp;

	public ErrorResponse() {

	}

	public ErrorResponse(String code, String message, List<String> details, LocalDateTime timestamp) {
		super();
		this.code = code;
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


}
