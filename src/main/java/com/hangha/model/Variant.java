package com.hangha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.springframework.hateoas.ResourceSupport;

@Entity
public class Variant extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer variantId;
	private String alteration;
	private String consequenceTerm;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isGenerallyTruncating;
	
	@ManyToOne
	private Gene gene;
	
	public Variant(){
		super();
	}
	
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
	
	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}
}
