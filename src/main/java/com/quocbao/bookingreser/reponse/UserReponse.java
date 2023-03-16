package com.quocbao.bookingreser.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.common.UserEmployeeInfor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserReponse extends UserEmployeeInfor{

	@JsonProperty("id")
	private Long id;
}
