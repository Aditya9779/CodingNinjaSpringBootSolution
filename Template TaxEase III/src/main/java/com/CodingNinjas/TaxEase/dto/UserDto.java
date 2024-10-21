package com.CodingNinjas.TaxEase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String username;
	private String password;
	private int age;
	private String role;

}
