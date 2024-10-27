package com.CN.PharmaLink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	@NotBlank(message = "Username cannot be blank")
	private String username;
	@NotBlank(message = "password cannot be blank")
	private String password;
	@NotBlank(message = "X Coordinate cannot be blank")
	private Long xcoordinate;
	@NotBlank(message = "Y Coordinate cannot be blank")
	private Long ycoordinate;

}
