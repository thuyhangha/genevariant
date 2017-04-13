package com.hangha.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.hangha.model.Gene;
import com.hangha.repository.base.BaseRepository;

public interface GeneRepository extends BaseRepository<Gene>, QueryDslPredicateExecutor<Gene>{
}
