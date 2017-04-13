package com.hangha.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hangha.model.Gene;
import com.hangha.services.FetchVariantServices;
import com.hangha.services.GeneServices;
import com.hangha.services.VariantServices;

@RestController
public class GeneController {
	
	@Autowired
	private FetchVariantServices fetchVariantServices; 
	
	@Autowired
	private GeneServices geneServices;
	
	@Autowired
	private VariantServices variantServices;
	
	
	@RequestMapping("/fetchVariants")
    public String fetchVariants() {
		String url = "http://oncokb.org/api/v1/genes/673/variants";
		JSONArray response = fetchVariantServices.fetchVariantData(url);
		for(int i = 0; i < response.length(); i++) {
			try {
				JSONObject object = response.getJSONObject(i);
				JSONObject gene = object.getJSONObject("gene");
				int entrezGeneId = gene.getInt("entrezGeneId");
				Gene geneDB = geneServices.get(entrezGeneId);
				if(geneDB == null) {
					String hugoSymbol = object.getString("hugoSymbol");
					ArrayList<String> geneAliases = new ArrayList<>();
					JSONArray geneAliasesJson = object.getJSONArray("geneAliases");
					for(int j = 0; j < geneAliasesJson.length(); j++) {
						String aliases = geneAliasesJson.getString(j);
						geneAliases.add(aliases);
					}
					boolean oncogene = object.getBoolean("oncogene");
					boolean tsg = object.getBoolean("tsg");
					geneDB = new Gene(entrezGeneId, hugoSymbol, geneAliases, oncogene, tsg);
					geneServices.add(geneDB);
				}
				JSONObject consequence = object.getJSONObject("consequence");
				String alteration = object.getString("alteration");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return response.toString();
    }
}
