package com.template.app.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.request.UpdateMemberReq;
import com.template.app.model.response.MemberInfoRes;
import com.template.app.service.MemberAppService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberAppService memberAppService;

	@GetMapping("/member")
	public MemberInfoRes getMember(@Valid @NotNull @Min(1) @RequestParam Integer memberNo){
		return memberAppService.getMember(memberNo);
	}

	@PostMapping("/member")
	public void saveMember(@RequestBody @Valid CreateMemberReq req){
		memberAppService.saveMember(req);
	}

	@PutMapping("/member")
	public void updateMember(@RequestBody @Valid UpdateMemberReq req){
		memberAppService.updateMember(req);
	}
}
