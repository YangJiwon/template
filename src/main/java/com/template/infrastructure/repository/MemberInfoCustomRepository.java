package com.template.infrastructure.repository;

import com.template.infrastructure.entitiy.MemberEntity;

public interface MemberInfoCustomRepository {
    MemberEntity getMemberByName(String memberName);
}
