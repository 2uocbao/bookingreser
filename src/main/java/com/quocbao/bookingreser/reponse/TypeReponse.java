package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.TypeRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeReponse extends TypeRequest{
	
	@JsonProperty("name")
	private String name;
}
