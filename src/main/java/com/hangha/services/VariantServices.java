package com.hangha.services;

import com.hangha.model.Variant;

public interface VariantServices {
	public Variant get(int geneId);
	public void add(Variant variant);
}
