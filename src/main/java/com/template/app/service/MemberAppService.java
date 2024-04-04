package com.template.app.service;

import org.springframework.stereotype.Service;

import com.template.app.mapper.MemberInfoResMapper;
import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.request.UpdateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.infrastructure.model.MemberInfoModel;
import com.template.infrastructure.service.MemberInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberAppService {
	private final MemberInfoService memberInfoService;
	private final MemberInfoResMapper mapper;

	public MemberInfoRes getMember(Integer memberNo){
		MemberInfoModel model = memberInfoService.getMember(memberNo);
		return mapper.toInfoRes(model);
	}

	public void saveMember(CreateMemberReq req){
		MemberInfoModel model = mapper.toModel(req);
		memberInfoService.saveMember(model);
	}

	public void updateMember(UpdateMemberReq req){
		MemberInfoModel model = mapper.toModel(req);
		memberInfoService.updateMember(model);
	}
}
