package com.template.app.model.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.template.app.constants.DateTimePatternConstant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder(toBuilder = true)
public record MemberInfoRes(
		@Schema(description = "회원 번호", example = "3")
        Integer memberNo,

		@Schema(description = "회원 이름", example = "하이")
		String memberName,

		@Schema(description = "회원 기타 이름", example = "하이etc")
        String memberEtcName,

		@Schema(description = "등록 일시(YYYY-MM-DD HH:MM:SS:SSS)", example = "2023-01-01 12:00:00:000")
		@JsonFormat(pattern = DateTimePatternConstant.YYYY_MM_DD_HH_MM_SS_SSS)
		LocalDateTime createdAt,

		@Schema(description = "수정 일시(YYYY-MM-DD HH:MM:SS:SSS)", example = "2023-01-01 12:00:00:000")
		@JsonFormat(pattern = DateTimePatternConstant.YYYY_MM_DD_HH_MM_SS_SSS)
		LocalDateTime updatedAt
) {
}
