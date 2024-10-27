package com.rituraj.blog.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	private String title;
	
	private String content;
	
	private String imageName;	
	
	private Date addedDate;
}
