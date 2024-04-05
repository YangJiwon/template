package com.template.app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.request.UpdateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.app.service.MemberAppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberControllerApi{
	private final MemberAppService memberAppService;

	public MemberInfoRes getMember(@RequestParam Integer memberNo){
		return memberAppService.getMember(memberNo);
	}

	public MemberInfoRes getMemberByName(@RequestParam String memberName){
		return memberAppService.getMemberByName(memberName);
	}

	public void saveMember(@RequestBody CreateMemberReq req){
		memberAppService.saveMember(req);
	}

	public void updateMember(@RequestBody UpdateMemberReq req){
		memberAppService.updateMember(req);
	}
}
