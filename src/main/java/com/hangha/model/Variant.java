package com.hangha.model;

public class Variant {
	private int alteration;
	private String consequenceTerm;
	private int isGenerallyTruncating;
	private int entrezGeneId;
	public Variant(int alteration, String consequenceTerm, int isGenerallyTruncating, int entrezGeneId) {
		super();
		this.alteration = alteration;
		this.consequenceTerm = consequenceTerm;
		this.isGenerallyTruncating = isGenerallyTruncating;
		this.entrezGeneId = entrezGeneId;
	}
	
	public int getAlteration() {
		return alteration;
	}
	public void setAlteration(int alteration) {
		this.alteration = alteration;
	}
	public String getConsequenceTerm() {
		return consequenceTerm;
	}
	public void setConsequenceTerm(String consequenceTerm) {
		this.consequenceTerm = consequenceTerm;
	}
	public int getIsGenerallyTruncating() {
		return isGenerallyTruncating;
	}
	public void setIsGenerallyTruncating(int isGenerallyTruncating) {
		this.isGenerallyTruncating = isGenerallyTruncating;
	}
	public int getEntrezGeneId() {
		return entrezGeneId;
	}
	public void setEntrezGeneId(int entrezGeneId) {
		this.entrezGeneId = entrezGeneId;
	}
}
