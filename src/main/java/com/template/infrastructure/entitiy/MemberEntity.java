package com.template.infrastructure.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "MEMBER")
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberEntity extends BaseEntity{

	@Id
	@Column(name = "MEMBER_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberNo;

	@Setter
	@Column(name = "MEMBER_NAME")
	private String memberName;

	@Setter
	@Column(name = "MEMBER_ETC_NAME")
	private String memberEtcName;
}
