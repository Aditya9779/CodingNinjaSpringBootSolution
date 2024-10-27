package com.CN.StoreFinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private String username;
	private String password;
	private Long xCoordinate;
	private Long yCoordinate;

}
