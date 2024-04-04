package com.template.infrastructure.model;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder(toBuilder = true)
public record MemberInfoModel(
        Integer memberNo,
        String memberName,
        String memberEtcName,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
) {
}
