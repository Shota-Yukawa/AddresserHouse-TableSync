package com.ah.tablesync.datasource.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ah.tablesync.datasource.entity.primary.ApartownersEntity;

@Repository
public interface ApartownerRepository extends JpaRepository<ApartownersEntity, Integer> {

}
