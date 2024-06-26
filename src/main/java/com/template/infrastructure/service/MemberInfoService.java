package com.template.infrastructure.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.template.common.exception.BusinessErrorCodeException;
import com.template.common.exception.ErrorCode;
import com.template.infrastructure.entitiy.MemberEntity;
import com.template.infrastructure.mapper.MemberInfoMapper;
import com.template.infrastructure.model.MemberInfoModel;
import com.template.infrastructure.repository.MemberInfoCustomRepository;
import com.template.infrastructure.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberInfoService {
	private final MemberRepository memberRepository;
	private final MemberInfoCustomRepository memberInfoCustomRepository;
	private final MemberInfoMapper mapper;

	public MemberInfoModel find(Integer memberNo){
		MemberEntity entity = this.findById(memberNo);
		return mapper.toInfoModel(entity);
	}

	public MemberInfoModel findMemberByName(String memberName){
		MemberEntity entity = memberRepository.findByMemberName(memberName);
		return mapper.toInfoModel(entity);
	}

	private MemberEntity findById(Integer memberNo){
		return memberRepository.findById(memberNo).orElseThrow(() -> new BusinessErrorCodeException(ErrorCode.MEMBER_01));
	}

	@Transactional
	public void saveMember(MemberInfoModel model){
		MemberEntity entity = mapper.toEntity(model);
		memberRepository.save(entity);
	}

	@Transactional
	public void updateMember(MemberInfoModel model){
		Integer memberNo = model.memberNo();
		MemberEntity entity = this.findById(memberNo);

		entity.changeName(model.memberName(), model.memberEtcName());
	}
}
