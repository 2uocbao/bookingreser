package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.request.OrderRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderReponse extends OrderRequest{

	@JsonProperty("id")
	private Long id;
}
