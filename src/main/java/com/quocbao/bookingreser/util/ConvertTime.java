package com.quocbao.bookingreser.util;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ConvertTime {

	public LocalDate fromTimestamp(Timestamp timestamp) {
		return timestamp.toLocalDateTime().toLocalDate();
	}
	
}
