package com.example.MongdoDb.RolesModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.MongdoDb.Enums.ERoles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "roles")
public class Roles {

	@Id
	private String id;
	private ERoles roles;

}
