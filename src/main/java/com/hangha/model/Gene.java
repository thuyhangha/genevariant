package com.hangha.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gene {
	@Id
	@Column(name="entrezGeneId")
	private int entrezGeneId;
	
	private String hugoSymbol;
	
	private ArrayList<String> geneAliases;
	
	private boolean oncogene = false;
	
	private boolean tsg = false;
	
	public Gene(int entrezGeneId, String hugoSymbol, ArrayList<String> geneAliases, boolean oncogene, boolean tsg) {
		super();
		this.entrezGeneId = entrezGeneId;
		this.hugoSymbol = hugoSymbol;
		this.geneAliases = geneAliases;
		this.oncogene = oncogene;
		this.tsg = tsg;
	}
	
	public int getEntrezGeneId() {
		return entrezGeneId;
	}
	public void setEntrezGeneId(int entrezGeneId) {
		this.entrezGeneId = entrezGeneId;
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
}
