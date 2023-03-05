package com.example.MongdoDb.Security;

import com.example.MongdoDb.Enums.ERoles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {

	private String token;
	private String roles;
	private String firstname;
}
