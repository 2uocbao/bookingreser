package com.quocbao.bookingreser.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quocbao.bookingreser.common.UserEmployeeInfor;

import lombok.Getter;

@Getter
public class EmpUserRequest extends UserEmployeeInfor{

	@JsonProperty("companyId")
	public Long companyId;
}
