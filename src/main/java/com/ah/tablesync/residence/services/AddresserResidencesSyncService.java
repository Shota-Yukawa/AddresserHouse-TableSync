package com.ah.tablesync.residence.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ah.querydatasource.entity.residence.AddresserResidencesEntity;
import com.ah.querydatasource.repository.residence.AddresserResidencesRepository;
import com.ah.tablesync.models.request.residence.AddresserResidenceSyncReqBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddresserResidencesSyncService {

	private final AddresserResidencesRepository rep;
	private final ModelMapper modelMapper;

	/**
	 * addresser_residencesテーブルの登録/更新をqueryDBに同期する。
	 */
	public void syncUpsert(AddresserResidenceSyncReqBean reqEntity) {

		// テーブル同期リクエストBeanをentityにマッピング
		AddresserResidencesEntity entity = modelMapper.map(reqEntity, AddresserResidencesEntity.class);

		// 保存
		rep.save(entity);

	}

	/**
	 * addresser_residencesテーブルへの削除をqueryDBに同期する
	 * @param id
	 */
	public void syncDelete(Integer id) {
		rep.deleteById(id);
	}
}
