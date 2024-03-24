package com.ah.tablesync.models.request.residence;

import com.ah.tablesync.models.request.parts.SystemDateParts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartResidenceSyncReqBean extends SystemDateParts{

	private Integer apartResidenceId;
	
	private Integer consumerId;
	
	private Integer apartmentId;
	
	private Integer roomNum;
	
}
