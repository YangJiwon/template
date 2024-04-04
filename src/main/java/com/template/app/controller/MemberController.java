package com.template.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.app.service.MemberAppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberAppService memberAppService;

	@PostMapping("/member")
	public void saveMember(@RequestBody CreateMemberReq req){
		memberAppService.saveMember(req);
	}

	@GetMapping("/member")
	public MemberInfoRes getMember(@RequestParam Integer memberNo){
		return memberAppService.getMember(memberNo);
	}
}
