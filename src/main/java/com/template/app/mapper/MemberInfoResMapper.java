package com.template.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.infrastructure.model.MemberInfoModel;

@Mapper
public interface MemberInfoResMapper {
	MemberInfoRes toInfoRes(MemberInfoModel model);

	@Mapping(ignore = true, target = "memberNo")
	@Mapping(ignore = true, target = "createdAt")
	@Mapping(ignore = true, target = "updatedAt")
	MemberInfoModel toModel(CreateMemberReq req);
}
