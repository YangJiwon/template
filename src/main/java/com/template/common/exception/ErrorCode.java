package com.template.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	MEMBER_01(HttpStatus.BAD_REQUEST, "멤버 정보가 없습니다."),
	ERROR2(HttpStatus.BAD_REQUEST, "error_2");

	private final HttpStatus httpStatus;
	private final String errMsg;
}
