package com.template.infrastructure.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.template.infrastructure.entitiy.MemberEntity;
import com.template.infrastructure.entitiy.QMemberEntity;

@Repository
public class MemberInfoCustomRepositoryImpl extends QuerydslRepositorySupport implements MemberInfoCustomRepository {

	private static final QMemberEntity t_member_info = QMemberEntity.memberEntity;

	public MemberInfoCustomRepositoryImpl() {
		super(MemberEntity.class);
	}

	@Override
	public MemberEntity getMemberByName(String memberName) {
		return from(t_member_info)
				.where(eqMemberName(memberName))
				.fetchOne();
	}

	private BooleanExpression eqMemberName(String memberName) {
		return ObjectUtils.isEmpty(memberName) ? null : t_member_info.memberName.eq(memberName);
	}
}
