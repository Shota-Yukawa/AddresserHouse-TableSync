package com.ah.tablesync.aparowner.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ah.querydatasource.entity.apartowner.ApartownersEntity;
import com.ah.querydatasource.repository.apartowner.ApartownerRepository;
import com.ah.tablesync.models.request.apartowner.ApartownerSyncReqBean;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional // メソッド開始時にトランザクションを開始、終了時にコミットする
public class ApartownerSyncService {

	private final ApartownerRepository rep;
	private final ModelMapper modelMapper;

	public void syncInsert(ApartownerSyncReqBean reqEntity) {

		// テーブル同期リクエストBeanをentityにマッピング
		ApartownersEntity entity = modelMapper.map(reqEntity, ApartownersEntity.class);

		// 保存
		rep.save(entity);

	}
}
