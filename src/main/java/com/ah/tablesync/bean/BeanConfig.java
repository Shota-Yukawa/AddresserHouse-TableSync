package com.ah.tablesync.bean;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setSkipNullEnabled(true); // nullはマッピングしない
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 厳密なマッピング
		modelMapper.getConfiguration().setFullTypeMatchingRequired(true); // マッピング条件として型もチェックする
		return modelMapper;
	}
}
