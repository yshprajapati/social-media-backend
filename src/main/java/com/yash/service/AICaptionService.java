package com.yash.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.yash.dto.CaptionRequestDTO;


@Service
public class AICaptionService {
	
	@Autowired
	private WebClient webClient;
	
	@Value("${gemini.api.key}")
	private String key;
	
	@Value("${gemini.api.url}")
	private String url;
	
	public String generateCaption(CaptionRequestDTO dto) {
		
		String prompt = "Generate a short "+dto.getCaptionTone()+" Instagram caption for: "+dto.getCaptionTitle();
		
		 Map<String, Object> requestBody = Map.of(
	                "contents", new Object[] {
	                        Map.of(
	                                "parts", new Object[] {
	                                        Map.of("text", prompt)
	                                })
	                });

		
		String response = webClient.post()
		.uri(url + "?key=" + key)
		.header("Content-Type", "application/json")
		.bodyValue(requestBody)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		return response;
	}
}
