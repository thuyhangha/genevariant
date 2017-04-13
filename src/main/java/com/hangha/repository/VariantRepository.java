package com.hangha.repository;

import java.util.List;

import com.hangha.model.Gene;
import com.hangha.model.Variant;
import com.hangha.repository.base.BaseRepository;

public interface VariantRepository extends BaseRepository<Variant>{
	public List<Variant> findBygene(Gene gene);
	public List<Variant> findBygeneEntrezGeneId(int geneId);
}
