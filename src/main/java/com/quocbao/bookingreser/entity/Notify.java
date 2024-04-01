package com.quocbao.bookingreser.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notify {
	
	private String content;
	private MessageType type;
	
	public enum MessageType {
		OFFER,
		NEW,
		ON,
	}
}
