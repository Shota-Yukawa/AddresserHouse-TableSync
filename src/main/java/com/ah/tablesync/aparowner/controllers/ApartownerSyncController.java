package com.ah.tablesync.aparowner.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ah.commonlib.JsonConverter;
import com.ah.tablesync.aparowner.services.ApartownerSyncService;
import com.ah.tablesync.models.request.apartowner.ApartownerSyncReqBean;
import com.ah.tablesynclib.bean.TableSyncRequestBean;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("apartowner")
@RequiredArgsConstructor
public class ApartownerSyncController {

	private final ApartownerSyncService service;

	/**
	 * apartownersテーブル[登録]からのqueryの同期リクエストを処理
	 * @param body
	 * @return
	 */
	@PostMapping("insert")
	public String insertSysc(@RequestBody TableSyncRequestBean body) {
		ApartownerSyncReqBean reqEntity = JsonConverter.deserializeJson(body.getData(), ApartownerSyncReqBean.class);
		service.syncUpsert(reqEntity);
		return "success";
	}
	
	/**
	 * apartownersテーブル[更新]からのqueryの同期リクエストを処理
	 * @param body
	 * @return
	 */
	@PutMapping("update")
	public String updateSysc(@RequestBody TableSyncRequestBean body) {
		ApartownerSyncReqBean reqEntity = JsonConverter.deserializeJson(body.getData(), ApartownerSyncReqBean.class);
		service.syncUpsert(reqEntity);
		return "success";
	}
	
	/**
	 * apartownersテーブル[削除]からのqueryの同期リクエストを処理
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public String deleteSysc(@PathVariable Integer id) {
		service.syncDelete(id);
		return "success";
	}
}
