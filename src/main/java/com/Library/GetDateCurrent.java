package com.Library;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateCurrent {

	
	public void get(String cureentDate) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd_MM_yyyy_hh:mm:ss");
		Date date = new Date();
		cureentDate=formatter.format(date);
	}
} 
