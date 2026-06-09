package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.CaptionRequestDTO;
import com.yash.dto.CaptionResponseDTO;
import com.yash.service.AICaptionService;

@RestController
@RequestMapping("/api/ai_caption")
public class AICaptionController {
	
	@Autowired
	private AICaptionService service;
	
	@PostMapping("/generate")
	public ResponseEntity<CaptionResponseDTO> generateCaption(@RequestBody CaptionRequestDTO dto) {
		String caption = service.generateCaption(dto);
		CaptionResponseDTO responseDto = new CaptionResponseDTO(caption);
		return ResponseEntity.ok(responseDto);
	}
}
