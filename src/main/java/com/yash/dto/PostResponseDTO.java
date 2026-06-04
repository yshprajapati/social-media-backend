package com.yash.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponseDTO {

    private Long id;
    private String content;
    private String imgUrl;
    private LocalDate createdAt;
}
