package com.hangha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public @ResponseBody Page<Variant> fetchVariants(@RequestParam("page") Integer page,
    		@RequestParam("size") Integer size) {
		Page<Variant> variants = variantServices.gets(page, size);
		return variants;
    }
}
