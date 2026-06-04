package com.yash.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PostRequestDTO {
	private String content;
	@NotBlank(message ="Image URL is required")
    private String imgUrl;
}
