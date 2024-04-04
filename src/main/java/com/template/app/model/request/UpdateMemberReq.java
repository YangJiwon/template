package com.template.app.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberReq(
		@NotNull
		@Min(1)
		@Schema(description = "회원 번호", example = "3")
		Integer memberNo,

		@Schema(description = "회원 이름", example = "하이")
		String memberName,

		@Schema(description = "회원 기타 이름", example = "하이etc")
		String memberEtcName
){
}
