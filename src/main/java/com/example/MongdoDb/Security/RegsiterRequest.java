package com.example.MongdoDb.Security;

import com.example.MongdoDb.Enums.ERoles;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegsiterRequest {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String contact;

}
