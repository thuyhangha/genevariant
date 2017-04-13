package com.hangha.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.hangha.model.Gene;
import com.hangha.repository.GeneRepository;
import com.hangha.services.GeneServices;

public class GeneServicesImpl implements GeneServices{

	@Autowired
	private GeneRepository geneRepository;
	
	@Override
	public Gene get(Integer id) {
		return geneRepository.findOne(id);
	}

	@Override
	public void add(Gene gene) {
		geneRepository.save(gene);
	}

	@Override
    public Page<Gene> gets(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        return geneRepository.findAll(pageRequest);
    }

}
