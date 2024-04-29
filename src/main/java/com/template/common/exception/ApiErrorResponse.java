package com.template.common.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.template.app.constants.DateTimePatternConstant;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DateTimePatternConstant.YYYY_MM_DD_HH_MM_SS);

	private final String timestamp;
	private final int status;
	private final String error;
	private final String code;
	private final String message;

	public ApiErrorResponse(int status, String error, String code, String message) {
		this.timestamp = LocalDateTime.now().format(FORMATTER);
		this.status = status;
		this.error = error;
		this.code = code;
		this.message = message;
	}

	public static ResponseEntity<ApiErrorResponse> toResponse(ErrorCode errorCode) {
		HttpStatus status = errorCode.getHttpStatus();
		ApiErrorResponse errorResponse = new ApiErrorResponse(
				status.value(),
				status.name(),
				errorCode.name(),
				errorCode.getErrMsg()
		);

		return ResponseEntity
				.status(status)
				.body(errorResponse);
	}

	public static ResponseEntity<ApiErrorResponse> toResponse(HttpStatus status, String msg) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(
				status.value(),
				status.name(),
				"",
				msg
		);

		return ResponseEntity
				.status(status)
				.body(errorResponse);
	}
}
