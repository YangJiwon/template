package com.template.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	MEMBER_01(HttpStatus.BAD_REQUEST, "멤버 정보가 없습니다."),
	ERROR2(HttpStatus.BAD_REQUEST, "error_2");

	private final HttpStatus httpStatus;
	private final String errMsg;
}
