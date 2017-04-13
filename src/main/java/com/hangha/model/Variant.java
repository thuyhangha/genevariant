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
	private String alteration;
	private String consequenceTerm;
	private boolean isGenerallyTruncating;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Gene gene;
	
	public Variant(String alteration, String consequenceTerm, boolean isGenerallyTruncating,  Gene gene) {
		super();
		this.alteration = alteration;
		this.consequenceTerm = consequenceTerm;
		this.isGenerallyTruncating = isGenerallyTruncating;
		this.setGene(gene);
	}
	
	public String getAlteration() {
		return alteration;
	}
	public void setAlteration(String alteration) {
		this.alteration = alteration;
	}
	public String getConsequenceTerm() {
		return consequenceTerm;
	}
	public void setConsequenceTerm(String consequenceTerm) {
		this.consequenceTerm = consequenceTerm;
	}
	public boolean getIsGenerallyTruncating() {
		return isGenerallyTruncating;
	}
	public void setIsGenerallyTruncating(boolean isGenerallyTruncating) {
		this.isGenerallyTruncating = isGenerallyTruncating;
	}

	public Gene getGene() {
		return this.gene;
	}

	public void setGene(Gene gene) {
		this.gene = gene;
	}
	
}
