package com.hangha.services.impl;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hangha.model.Gene;
import com.hangha.repository.GeneRepository;
import com.hangha.services.GeneServices;

@Service
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

	/*@Override
	public List<Gene> findAll(Predicate predicate) {
		Predicate predicate = user.firstname.equalsIgnoreCase("dave")
				.and(user.lastname.startsWithIgnoreCase("mathews"));

		return geneRepository.findAll(predicate);
	}*/

	@Override
	public Page<Gene> findByOncogene(Predicate predicate, Pageable pageable) {
		//Predicate predicate = Gene.get.firstname.equalsIgnoreCase("true");

		//return geneRepository.findAll(orders)
		return null;
	}

}
