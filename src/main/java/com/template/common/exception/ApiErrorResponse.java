package com.template.common.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.template.app.constants.DateTimePatternConstant;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public class ApiErrorResponse {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DateTimePatternConstant.YYYY_MM_DD_HH_MM_SS);

	private final String timestamp = LocalDateTime.now().format(FORMATTER);
	private final int status;
	private final String error;
	private final String code;
	private final String message;

	public static ResponseEntity<ApiErrorResponse> toResponse(ErrorCode errorCode) {
		HttpStatus status = errorCode.getHttpStatus();
		ApiErrorResponse errorResponse = ApiErrorResponse.builder()
				.status(status.value())
				.error(status.name())
				.code(errorCode.name())
				.message(errorCode.getErrMsg())
				.build();

		return ResponseEntity
				.status(status)
				.body(errorResponse);
	}

	public static ResponseEntity<ApiErrorResponse> toResponse(String msg) {
		return toResponse(HttpStatus.INTERNAL_SERVER_ERROR, msg);
	}

	public static ResponseEntity<ApiErrorResponse> toResponse(HttpStatus status, String msg) {
		ApiErrorResponse errorResponse = ApiErrorResponse.builder()
				.status(status.value())
				.error(status.name())
				.message(msg)
				.build();

		return ResponseEntity
				.status(status)
				.body(errorResponse);
	}
}
