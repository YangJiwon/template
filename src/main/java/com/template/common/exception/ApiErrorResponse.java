package com.template.common.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ApiErrorResponse {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	private final String timestamp = LocalDateTime.now().format(FORMATTER);
	private final int status;
	private final String error;
	private final String code;
	private final String message;

	public static ResponseEntity<ApiErrorResponse> toResponse(ErrorCode errorCode) {
		ApiErrorResponse errorResponse = ApiErrorResponse.builder()
				.status(errorCode.getHttpStatus().value())
				.error(errorCode.getHttpStatus().name())
				.code(errorCode.name())
				.message(errorCode.getErrMsg())
				.build();

		return ResponseEntity
				.status(errorCode.getHttpStatus())
				.body(errorResponse);
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
