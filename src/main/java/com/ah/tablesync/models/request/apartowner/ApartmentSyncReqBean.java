package com.ah.tablesync.models.request.apartowner;

import java.time.LocalDate;

import com.ah.querydatasource.entity.apartowner.ApartownersEntity;
import com.ah.tablesync.models.request.parts.SystemDateParts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentSyncReqBean extends SystemDateParts{

	private Integer apartmentId;

	private ApartownersEntity apartowner;

	private String apartName;

	private String apartNameKana;

	private int numOfRoom;

	private int numOfFloor;

	private LocalDate buildOn;

	private String postCode;

	private Integer addressId;

	private String afterStreet;

}
