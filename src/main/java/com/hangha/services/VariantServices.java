package com.hangha.services;

import org.springframework.data.domain.Page;

import com.hangha.model.Variant;
import com.hangha.services.base.BaseServices;

public interface VariantServices extends BaseServices<Variant>{
	public Page<Variant> getByGeneId(int geneId, Integer page, Integer size);
}
