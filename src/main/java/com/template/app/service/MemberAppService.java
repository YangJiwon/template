package com.template.app.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.template.app.mapper.MemberInfoResMapper;
import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.request.UpdateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.common.exception.BusinessErrorCodeException;
import com.template.common.exception.ErrorCode;
import com.template.infrastructure.model.MemberInfoModel;
import com.template.infrastructure.service.MemberInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberAppService {
	private final MemberInfoService memberInfoService;
	private final MemberInfoResMapper mapper;

	public MemberInfoRes find(Integer memberNo){
		MemberInfoModel model = memberInfoService.find(memberNo);
		return mapper.toInfoRes(model);
	}

	public MemberInfoRes getMemberByName(String memberName){
		MemberInfoModel model = memberInfoService.findMemberByName(memberName);
		if (ObjectUtils.isEmpty(model)){
			throw new BusinessErrorCodeException(ErrorCode.MEMBER_01);
		}
		return mapper.toInfoRes(model);
	}

	public void saveMember(CreateMemberReq req){
		MemberInfoModel findMember = memberInfoService.findMemberByName(req.memberName());
		if (!ObjectUtils.isEmpty(findMember)){
			throw new BusinessErrorCodeException(ErrorCode.MEMBER_02);
		}
		MemberInfoModel model = mapper.toModel(req);
		memberInfoService.saveMember(model);
	}

	public void updateMember(UpdateMemberReq req){
		MemberInfoModel model = mapper.toModel(req);
		memberInfoService.updateMember(model);
	}
}
