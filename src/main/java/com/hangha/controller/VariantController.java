package com.hangha.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hangha.model.Variant;
import com.hangha.services.VariantServices;

@RestController
public class VariantController extends BaseController {
	
	@Autowired
	private VariantServices variantServices;
	
	@RequestMapping("/variants")
    public @ResponseBody Page<Variant> fetchAllVariants(@RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Variant> variants = variantServices.gets(page, size);
		return variants;
    }
	
	@RequestMapping("/variants/{id}")
    public @ResponseBody Variant fetchVariantById(@PathVariable String id) {
		Variant variant = variantServices.get(Integer.parseInt(id));
		return variant;
    }
	
	@RequestMapping(path="/fetchAllVarientsHateoas", method=RequestMethod.GET)
    public @ResponseBody Page<Variant> fetchAllGeneHateoas(@RequestParam("page") Integer page,
		@RequestParam("size") Integer size) {

		Page<Variant> fetchAllVariantsPaging = variantServices.gets(page, size);
		List<Variant> fetchAllVariantsPagingContent = fetchAllVariantsPaging.getContent();
		
		for (int i = 0; i < fetchAllVariantsPagingContent.size(); i++) {
			Variant variant = fetchAllVariantsPagingContent.get(i);
			Integer variantId = variant.getVariantId();
			
			Variant fetchAllVariantsMethodLinkBuilder = methodOn(VariantController.class).fetchVariantById(variantId.toString());
            Link variantsPagingLink = linkTo(fetchAllVariantsMethodLinkBuilder).withSelfRel();
            variant.add(variantsPagingLink);
		}

		return fetchAllVariantsPaging;
    }
}
