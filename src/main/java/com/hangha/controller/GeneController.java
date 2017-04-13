package com.hangha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hangha.model.Gene;
import com.hangha.model.Variant;
import com.hangha.services.GeneServices;
import com.hangha.services.VariantServices;

@RestController
public class GeneController extends BaseController {
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
	
	@RequestMapping("/genes/{id}")
    public @ResponseBody Gene fetchVariants(@PathVariable String id) {
		Gene gene = geneServices.get(Integer.parseInt(id));
		return gene;
    }
	
	@RequestMapping("/genes/{id}/variants")
    public @ResponseBody Page<Variant> fetchVariantsWithPagining(@PathVariable String id, @RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Variant> variants = variantServices.getByGeneId(Integer.parseInt(id), page, size);
		return variants;
    }
	
	@RequestMapping(path="/fetchAllGeneHateoas", method=RequestMethod.GET)
    public @ResponseBody Page<Gene> fetchAllGeneHateoas(@RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Gene> genes = geneServices.gets(page, size);
		List<Gene> genesPageContent = genes.getContent();
		for (int i = 0; i < genesPageContent.size(); i++) {
			Gene gene = genesPageContent.get(i);
			Integer entrezGeneId = gene.getEntrezGeneId();

			//variantById : sample format http://localhost:8009/api/genes/673
			Gene variantsMethodLinkBuilder = methodOn(GeneController.class).fetchVariants(entrezGeneId.toString());
			Link variantsLink = linkTo(variantsMethodLinkBuilder).withSelfRel();
			gene.add(variantsLink);
			
			//variantPagingById: sample format http://localhost:8009/api/genes/673/variants?page=1&size=10
			Page<Variant> variantsPaging = variantServices.getByGeneId(entrezGeneId, page, size);
			List<Variant> variantsPagingContent = variantsPaging.getContent();
			if(variantsPagingContent.size() > 0){
				Page<Variant> variantsPagingMethodLinkBuilder = methodOn(GeneController.class).fetchVariantsWithPagining(entrezGeneId.toString(), page, size);
                Link variantsPagingLink = linkTo(variantsPagingMethodLinkBuilder).withRel("variants");
                gene.add(variantsPagingLink);
			}
		}
		return genes;
    }
}
