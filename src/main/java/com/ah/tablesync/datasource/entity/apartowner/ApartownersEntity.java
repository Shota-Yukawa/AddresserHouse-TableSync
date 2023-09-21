package com.ah.tablesync.datasource.entity.apartowner;

import com.ah.tablesync.datasource.entity.parts.SystemDateEntityParts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "apartowners")
@Data
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "pkey_seq", sequenceName = "apartowners_apartowner_id_seq", allocationSize = 1)
public class ApartownersEntity extends SystemDateEntityParts {

	@Id
	@Column(name = "apartowner_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkey_seq")
	private Integer apartownerId;

	@Column(name = "apartowner_name", nullable = false)
	private String apartownerName;

	@Column(name = "apartowner_name_kana")
	private String apartownerNameKana;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "max_user", nullable = false)
	private int maxUser = 5;

	@Column(name = "post_code")
	private String postCode;

	@Column(name = "address_id", nullable = false)
	private Integer addressId;

	@Column(name = "after_street")
	private String afterStreet;
}
