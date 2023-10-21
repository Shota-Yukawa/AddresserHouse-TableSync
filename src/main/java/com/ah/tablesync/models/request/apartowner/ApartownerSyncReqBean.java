package com.ah.tablesync.models.request.apartowner;

import lombok.Data;

@Data
public class ApartownerSyncReqBean {

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
