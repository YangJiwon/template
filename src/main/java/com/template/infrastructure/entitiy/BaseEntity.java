package com.template.infrastructure.entitiy;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
abstract class BaseEntity {

	@CreatedDate
	@Column(name = "CREATED_AT", updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "UPDATED_AT")
	private LocalDateTime updatedAt;
}
