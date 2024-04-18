package com.template.app.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateMemberReq (
		@NotBlank
		@Schema(description = "회원 이름", example = "하이")
		String memberName,

		@NotBlank
		@Schema(description = "회원 기타 이름", example = "하이etc")
		String memberEtcName
){
}
