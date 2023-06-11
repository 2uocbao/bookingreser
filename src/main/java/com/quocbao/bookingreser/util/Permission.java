package com.quocbao.bookingreser.util;

import lombok.Getter;

@Getter
public enum Permission {

	ADMIN, USER, STAFF;

	private String permission;
}
