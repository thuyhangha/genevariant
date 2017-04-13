package com.hangha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hangha.model.Variant;
import com.hangha.repository.base.BaseRepository;

public interface VariantRepository extends BaseRepository<Variant>{
	public Page<Variant> findByGeneEntrezGeneId(int id, Pageable pageable);
}
