package com.hangha.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Variant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private int alteration;
	private String consequenceTerm;
	private int isGenerallyTruncating;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Gene Gene;
	
	public Variant(int alteration, String consequenceTerm, int isGenerallyTruncating,  Gene Gene) {
		super();
		this.alteration = alteration;
		this.consequenceTerm = consequenceTerm;
		this.isGenerallyTruncating = isGenerallyTruncating;
		this.setGene(Gene);
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

	public Gene getGene() {
		return Gene;
	}

	public void setGene(Gene gene) {
		Gene = gene;
	}
	
}
