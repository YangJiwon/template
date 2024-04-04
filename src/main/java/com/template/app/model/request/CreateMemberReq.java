package com.template.app.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateMemberReq (
		@Schema(description = "회원 이름", example = "하이")
		String memberName,

		@Schema(description = "회원 기타 이름", example = "하이etc")
		String memberEtcName
){
}
