package com.rituraj.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min = 5, message = "Min size is 5")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "Min size is 10")
	private String categoryDescription;
}
