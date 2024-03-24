package com.ah.tablesync.residence.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ah.querydatasource.entity.residence.ApartResidencesEntity;
import com.ah.querydatasource.repository.residence.ApartResidencesRepository;
import com.ah.tablesync.models.request.residence.ApartResidenceSyncReqBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApartResidencesSyncService {

	private final ApartResidencesRepository rep;
	private final ModelMapper modelMapper;
	
	
	/**
	 * apart_residencesテーブルの登録/更新をqueryDBに同期する。
	 */
	public void syncUpsert(ApartResidenceSyncReqBean reqEntity) {

		// テーブル同期リクエストBeanをentityにマッピング
		ApartResidencesEntity entity = modelMapper.map(reqEntity, ApartResidencesEntity.class);

		// 保存
		rep.save(entity);

	}

	/**
	 * apart_residencesテーブルへの削除をqueryDBに同期する
	 * @param id
	 */
	public void syncDelete(Integer id) {
		rep.deleteById(id);
	}
}
