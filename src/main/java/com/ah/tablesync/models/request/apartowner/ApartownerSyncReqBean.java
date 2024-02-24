package com.ah.tablesync.models.request.apartowner;

import com.ah.tablesync.models.request.parts.SystemDateParts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartownerSyncReqBean extends SystemDateParts{

	private Integer apartownerId;

	private String apartownerName;

	private String apartownerNameKana;

	private String email;

	private String phoneNumber;

	private int maxUser = 5;

	private String postCode;

	private Integer addressId;

	private String afterStreet;
}
