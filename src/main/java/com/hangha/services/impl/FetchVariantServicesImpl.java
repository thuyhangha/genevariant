package com.hangha.services.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hangha.services.FetchVariantServices;


@Service
public class FetchVariantServicesImpl implements FetchVariantServices {

	@Override
	public JSONArray fetchVariantData(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		JSONArray resArray;
		try {
			resArray = new JSONArray(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			resArray = new JSONArray();
			e.printStackTrace();
		}
		return resArray;
	}
}
