package com.ah.tablesync.listeners;

import org.springframework.stereotype.Component;

import com.ah.tablesync.datasource.repository.primary.ApartownerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApartownerListener {

	private final ApartownerRepository repository;

}
