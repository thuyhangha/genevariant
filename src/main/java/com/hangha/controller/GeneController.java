package com.hangha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hangha.model.Gene;
import com.hangha.model.Variant;
import com.hangha.services.GeneServices;
import com.hangha.services.VariantServices;

@RestController
public class GeneController {
	@Autowired
	private GeneServices geneServices;
	
	@Autowired
	private VariantServices variantServices;
	
	@RequestMapping("/genes")
    public @ResponseBody Page<Gene> getGenes(@RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Gene> genes = geneServices.gets(page, size);
		return genes;
    }
	
	@RequestMapping("/genes/{id}/variants")
    public @ResponseBody Page<Variant> fetchVariants(@PathVariable String id, @RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Variant> variants = variantServices.getByGeneId(Integer.parseInt(id), page, size);
		return variants;
    }
}
