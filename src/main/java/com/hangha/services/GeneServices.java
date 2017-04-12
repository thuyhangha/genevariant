package com.hangha.services;

import com.hangha.model.Gene;

public interface GeneServices {
	public Gene get(int id);
	public void add(Gene gene);
}
