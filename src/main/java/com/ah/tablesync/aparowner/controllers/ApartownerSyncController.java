package com.ah.tablesync.aparowner.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ah.tablesync.aparowner.services.ApartownerSyncService;
import com.ah.tablesync.models.request.apartowner.ApartownerSyncReqBean;
import com.ah.tablesynclib.bean.TableSyncRequestBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("apartowner")
@RequiredArgsConstructor
public class ApartownerSyncController {

	private final ApartownerSyncService service;
	private final ObjectMapper objectMapper;

	@PostMapping("insert")
	public String insertSysc(@RequestBody TableSyncRequestBean body) {
		ApartownerSyncReqBean reqEntity = objectMapper.convertValue(body.getData(), ApartownerSyncReqBean.class);
		service.syncInsert(reqEntity);
		return "success";
	}
}
