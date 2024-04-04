package com.template.infrastructure.mapper;

import org.mapstruct.Mapper;
import com.template.infrastructure.entitiy.MemberEntity;
import com.template.infrastructure.model.MemberInfoModel;

@Mapper
public interface MemberInfoMapper {
	MemberInfoModel toInfoModel(MemberEntity entity);

	MemberEntity toEntity(MemberInfoModel model);
}
