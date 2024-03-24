package com.ah.tablesync.aparowner.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ah.querydatasource.entity.apartowner.ApartmentsEntity;
import com.ah.querydatasource.repository.apartowner.ApartmentsRepository;
import com.ah.tablesync.models.request.apartowner.ApartmentSyncReqBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApartmentsSyncService {
	
	private final ApartmentsRepository rep;
	private final ModelMapper modelMapper;
	
	
	/**
	 * apartownerテーブルの登録/更新をqueryDBに同期する。
	 */
	public void syncUpsert(ApartmentSyncReqBean reqEntity) {

		// テーブル同期リクエストBeanをentityにマッピング
		ApartmentsEntity entity = modelMapper.map(reqEntity, ApartmentsEntity.class);

		// 保存
		rep.save(entity);

	}

	/**
	 * apartownerテーブルへの削除をqueryDBに同期する
	 * @param id
	 */
	public void syncDelete(Integer id) {
		rep.deleteById(id);
	}
}
