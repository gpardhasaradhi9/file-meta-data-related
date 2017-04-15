package com.test.fm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCustomUtil {
	public static String FILE_STORE_LOCATION = "c:\\receivedFiles";

	public static String formatDate(Date inputDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return formatter.format(inputDate);
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate(new Date()));
	}
}
