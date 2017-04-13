package com.hangha.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
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
public class GeneController extends BaseController {
	@Autowired
	private GeneServices geneServices;

	@Autowired
	private VariantServices variantServices;

	@RequestMapping("/genes")
	public @ResponseBody Page<Gene> getGenes(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		Page<Gene> genes = geneServices.gets(page, size);
		List<Gene> genesPageContent = genes.getContent();
		for (int i = 0; i < genesPageContent.size(); i++) {
			Gene gene = genesPageContent.get(i);
			Link genesLink = generateGeneLink(gene);
			gene.add(genesLink);

			Integer entrezGeneId = gene.getEntrezGeneId();
			Page<Variant> variantsPaging = variantServices.getByGeneId(entrezGeneId, page, size);
			List<Variant> variantsPagingContent = variantsPaging.getContent();
			if (variantsPagingContent.size() > 0) {
				Page<Variant> variantsPagingMethodLinkBuilder = methodOn(GeneController.class)
						.fetchVariantsWithPagining(entrezGeneId.toString(), page, size);
				Link variantsPagingLink = linkTo(variantsPagingMethodLinkBuilder).withRel("variants");
				gene.add(variantsPagingLink);
			}
		}
		return genes;
	}

	@RequestMapping("/genes/{id}")
	public @ResponseBody Gene fetchVariants(@PathVariable String id) {
		Gene gene = geneServices.get(Integer.parseInt(id));
		Link genesLink = generateGeneLink(gene);
		gene.add(genesLink);
		return gene;
	}

	@RequestMapping("/genes/{id}/variants")
	public @ResponseBody Page<Variant> fetchVariantsWithPagining(@PathVariable String id,
			@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		Page<Variant> variants = variantServices.getByGeneId(Integer.parseInt(id), page, size);
		return variants;
	}
	
	private Link generateGeneLink(Gene gene) {
		Integer entrezGeneId = gene.getEntrezGeneId();
		Gene geneMethodLinkBuilder = methodOn(GeneController.class).fetchVariants(entrezGeneId.toString());
		Link genesLink = linkTo(geneMethodLinkBuilder).withSelfRel();
		return genesLink;
	}
}
