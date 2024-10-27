package com.example.socialMedia.dto;

import lombok.Data;

@Data
public class ConnectionResponseDto {
	private String name;
	private String emailId;
	private String company;
	private String username;
	private int level;
}
