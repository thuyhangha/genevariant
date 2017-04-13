package com.hangha.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hangha.model.Gene;
import com.hangha.model.Variant;
import com.hangha.services.FetchVariantServices;
import com.hangha.services.GeneServices;
import com.hangha.services.VariantServices;

@RestController
public class FetchVariantController extends BaseController {
	
	@Autowired
	private FetchVariantServices fetchVariantServices; 
	
	@Autowired
	private GeneServices geneServices;
	
	@Autowired
	private VariantServices variantServices;
	
	
	@RequestMapping("/data-init")
    public String fetchVariants() {
		String url = "http://oncokb.org/api/v1/genes/673/variants";
		JSONArray response = fetchVariantServices.fetchVariantData(url);
		for(int i = 0; i < response.length(); i++) {
			try {
				JSONObject object = response.getJSONObject(i);
				JSONObject gene = object.getJSONObject("gene");
				boolean oncogene = gene.getBoolean("oncogene");
				// Only use genes that are listed as an “OncoGene”
				if(oncogene == false) {
					continue;
				}
				int entrezGeneId = gene.getInt("entrezGeneId");
				String entrezGeneIdString = entrezGeneId + "";
				// Ignore empty entrezGeneId
				if(!entrezGeneIdString.isEmpty()){
					Gene geneDB = null;
					geneDB = geneServices.get(entrezGeneId);
					
					//gene does not exist on DB
					if(geneDB == null) {
						String hugoSymbol = gene.getString("hugoSymbol");
						ArrayList<String> geneAliases = new ArrayList<>();
						JSONArray geneAliasesJson = gene.getJSONArray("geneAliases");
						for(int j = 0; j < geneAliasesJson.length(); j++) {
							String aliases = geneAliasesJson.getString(j);
							geneAliases.add(aliases);
						}
						boolean tsg = gene.getBoolean("tsg");
						geneDB = new Gene(entrezGeneId, hugoSymbol, geneAliases, oncogene, tsg);
						geneServices.add(geneDB);
					}
					String alteration = object.getString("alteration");
					JSONObject consequence = object.getJSONObject("consequence");
					String consequenceTerm = consequence.getString("term");
					boolean isGenerallyTruncating = consequence.getBoolean("isGenerallyTruncating");
					Variant variant = new Variant(alteration, consequenceTerm, isGenerallyTruncating, geneDB);
					variantServices.add(variant);
				}
			} catch (JSONException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return "Initial data successfully";
    }
}
