package com.ah.tablesync.residence.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ah.commonlib.JsonConverter;
import com.ah.tablesync.models.request.residence.ApartResidenceSyncReqBean;
import com.ah.tablesync.residence.services.ApartResidencesSyncService;
import com.ah.tablesynclib.bean.TableSyncRequestBean;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("apart_residences")
@RequiredArgsConstructor
public class ApartResidencesSyncController {

	private final ApartResidencesSyncService service;
	private final JsonConverter jsonConverter;

	/**
	 * apart_residencesテーブル[登録]からのqueryの同期リクエストを処理
	 * @param body
	 * @return
	 */
	@PostMapping("insert")
	public String insertSysc(@RequestBody TableSyncRequestBean body) {
		ApartResidenceSyncReqBean reqEntity = jsonConverter.deserializeJson(body.getData(), ApartResidenceSyncReqBean.class);
		service.syncUpsert(reqEntity);
		return "success";
	}

	/**
	 * apart_residencesテーブル[更新]からのqueryの同期リクエストを処理
	 * @param body
	 * @return
	 */
	@PutMapping("update")
	public String updateSysc(@RequestBody TableSyncRequestBean body) {
		ApartResidenceSyncReqBean reqEntity = jsonConverter.deserializeJson(body.getData(), ApartResidenceSyncReqBean.class);
		service.syncUpsert(reqEntity);
		return "success";
	}

	/**
	 * apart_residencesテーブル[削除]からのqueryの同期リクエストを処理
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public String deleteSysc(@PathVariable Integer id) {
		service.syncDelete(id);
		return "success";
	}
}
