package com.example.MongdoDb.Model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class JobDTO {

	private String id;
	private String profile;
	private String desc;
	private int exp;
	private String techs[];

}
