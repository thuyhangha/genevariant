package com.hangha.services;

import java.util.function.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hangha.model.Gene;
import com.hangha.services.base.BaseServices;

public interface GeneServices extends BaseServices<Gene> {
	Page<Gene> findByOncogene(Predicate predicate, Pageable pageable);
}
