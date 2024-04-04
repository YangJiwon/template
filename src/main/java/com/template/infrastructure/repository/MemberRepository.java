package com.template.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.infrastructure.entitiy.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
