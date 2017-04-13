package com.hangha.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
public class Gene extends ResourceSupport{
	
	@Id
	@Column(name="entrezGeneId")
	private Integer  entrezGeneId;
	
	private String hugoSymbol;
	
	private ArrayList<String> geneAliases;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean oncogene = false;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean tsg = false;
	
	public Gene(){
		super();
	}
	
	public Gene(int entrezGeneId, String hugoSymbol, ArrayList<String> geneAliases, boolean oncogene, boolean tsg) {
		super();
		this.entrezGeneId = entrezGeneId;
		this.hugoSymbol = hugoSymbol;
		this.geneAliases = geneAliases;
		this.oncogene = oncogene;
		this.tsg = tsg;
	}
	
	public String getHugoSymbol() {
		return hugoSymbol;
	}
	public void setHugoSymbol(String hugoSymbol) {
		this.hugoSymbol = hugoSymbol;
	}
	public ArrayList<String> getGeneAliases() {
		return geneAliases;
	}
	public void setGeneAliases(ArrayList<String> geneAliases) {
		this.geneAliases = geneAliases;
	}
	public boolean isOncogene() {
		return oncogene;
	}
	public void setOncogene(boolean oncogene) {
		this.oncogene = oncogene;
	}
	public boolean isTsg() {
		return tsg;
	}
	public void setTsg(boolean tsg) {
		this.tsg = tsg;
	}

	public Integer getEntrezGeneId() {
		return entrezGeneId;
	}

	public void setEntrezGeneId(int entrezGeneId) {
		this.entrezGeneId = entrezGeneId;
	}

	public void setEntrezGeneId(Integer entrezGeneId) {
		this.entrezGeneId = entrezGeneId;
	}

	
}
