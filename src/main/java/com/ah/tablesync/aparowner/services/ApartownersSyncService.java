package com.ah.tablesync.aparowner.services;

import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ah.querydatasource.entity.apartowner.ApartownersEntity;
import com.ah.querydatasource.repository.apartowner.ApartownerRepository;
import com.ah.tablesync.exception.TableSyncException;
import com.ah.tablesync.models.request.apartowner.ApartownerSyncReqBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // メソッド開始時にトランザクションを開始、終了時にコミットする
public class ApartownersSyncService {

	private final ApartownerRepository rep;
	private final ModelMapper modelMapper;

	/**
	 * apartownerテーブルの登録/更新をqueryDBに同期する。
	 */
	public void syncUpsert(ApartownerSyncReqBean reqEntity) {

		// テーブル同期リクエストBeanをentityにマッピング
		ApartownersEntity entity = modelMapper.map(reqEntity, ApartownersEntity.class);

		// 保存
		rep.save(entity);

	}

	/**
	 * apartownerテーブルへの削除をqueryDBに同期する
	 * @param id
	 */
	public void syncDelete(Integer id) {
		try {
			// idで検索
			ApartownersEntity select = rep.findById(id).orElseThrow();
			rep.delete(select);//削除
		} catch (NoSuchElementException nsee) {
			throw new TableSyncException("同期リクエストのレコードは存在しません。");
		}
	}
}
