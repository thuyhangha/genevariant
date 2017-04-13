package com.hangha.services.base;

import org.springframework.data.domain.Page;

public interface BaseServices <T> {
	public T get(Integer id);
	public void add(T gene);
	public Page<T> gets(Integer page, Integer size);
}
