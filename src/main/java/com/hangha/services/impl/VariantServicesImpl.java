package com.hangha.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hangha.model.Variant;
import com.hangha.repository.VariantRepository;
import com.hangha.services.VariantServices;

@Service
public class VariantServicesImpl implements VariantServices {

	@Autowired
	private VariantRepository variantRepository;
	
	@Override
	public Variant get(Integer geneId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Variant variant) {
		variantRepository.save(variant);
	}

	@Override
    public Page<Variant> gets(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        return variantRepository.findAll(pageRequest);
    }
}
