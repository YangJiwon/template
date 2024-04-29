package com.template.app.controller;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.template.app.model.request.CreateMemberReq;
import com.template.app.model.request.UpdateMemberReq;
import com.template.app.model.response.MemberInfoRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Tag(name = "멤버", description = "멤버 API")
public interface MemberControllerApi {
	@Operation(
			summary = "멤버 조회",
			description = "멤버를 조회하는 API",
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MemberInfoRes.class)))
			}
	)
	@GetMapping("/member")
	MemberInfoRes findMember(@Parameter(description = "멤버 넘버", example = "1", name = "memberNo")
							@RequestParam @Valid @NotNull @Min(1) Integer memberNo);

	@Operation(
			summary = "이름으로 멤버 조회",
			description = " 이름으로 멤버를 조회하는 API",
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MemberInfoRes.class)))
			}
	)
	@GetMapping("/member/name")
	MemberInfoRes findMemberByName(@Parameter(description = "멤버 이름", example = "테스트", name = "memberName")
								  @RequestParam @Valid @NotBlank String memberName);

	@Operation(
			summary = "멤버 등록",
			description = "멤버를 등록하는 API",
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema()))
			}
	)
	@PostMapping(value = "/member")
	void saveMember(@RequestBody @Valid CreateMemberReq req);

	@Operation(
			summary = "멤버 수정",
			description = "멤버를 수정하는 API",
			responses = {
					@ApiResponse(description = "Success",
							responseCode = "200",
							content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema()))
			}
	)
	@PutMapping("/member")
	void updateMember(@RequestBody @Valid UpdateMemberReq req);
}
