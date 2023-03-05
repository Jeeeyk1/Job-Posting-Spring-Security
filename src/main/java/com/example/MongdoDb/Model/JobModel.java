package com.example.MongdoDb.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection="JobPost") //collection pertains to collection in db that will map into this pojo object
public class JobModel {

	private String id;
	private String profile;
	private String desc;
	private Integer exp;
	private String techs[];

}
