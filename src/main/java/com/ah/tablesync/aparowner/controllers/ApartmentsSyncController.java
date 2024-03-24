package com.ah.tablesync.aparowner.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ah.commonlib.JsonConverter;
import com.ah.tablesync.aparowner.services.ApartmentsSyncService;
import com.ah.tablesync.models.request.apartowner.ApartmentSyncReqBean;
import com.ah.tablesynclib.bean.TableSyncRequestBean;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("apartments")
@RequiredArgsConstructor
public class ApartmentsSyncController {
	
	 private final ApartmentsSyncService service;
	 private final JsonConverter jsonConverter;

	 /**
		 * apartmentsテーブル[登録]からのqueryの同期リクエストを処理
		 * @param body
		 * @return
		 */
		@PostMapping("insert")
		public String insertSysc(@RequestBody TableSyncRequestBean body) {
			ApartmentSyncReqBean reqEntity = jsonConverter.deserializeJson(body.getData(), ApartmentSyncReqBean.class);
			service.syncUpsert(reqEntity);
			return "success";
		}
		
		/**
		 * apartmentsテーブル[更新]からのqueryの同期リクエストを処理
		 * @param body
		 * @return
		 */
		@PutMapping("update")
		public String updateSysc(@RequestBody TableSyncRequestBean body) {
			ApartmentSyncReqBean reqEntity = jsonConverter.deserializeJson(body.getData(), ApartmentSyncReqBean.class);
			service.syncUpsert(reqEntity);
			return "success";
		}
		
		/**
		 * apartmentsテーブル[削除]からのqueryの同期リクエストを処理
		 * @param id
		 * @return
		 */
		@DeleteMapping("delete/{id}")
		public String deleteSysc(@PathVariable Integer id) {
			service.syncDelete(id);
			return "success";
		}
}
