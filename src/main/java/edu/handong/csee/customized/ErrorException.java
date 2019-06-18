package edu.handong.csee.customized;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ErrorException extends Exception{
	String fileName;
	public ErrorException()
	{
		super("Error exist");
	}
	public ErrorException(String file)
	{
		super("Error exist");
		fileName = file;
		
	}
	
	public void set() 
	{
		try {
		File excelName = new File("error.csv");
		if(!excelName.exists()) {			
			excelName.createNewFile();
			
		}
	
		
		BufferedWriter buffer1 = new BufferedWriter(new FileWriter("error.csv"));
		
	
			CSVPrinter csv1 = new CSVPrinter(buffer1,CSVFormat.DEFAULT);
			csv1.printRecord(fileName);
			
			csv1.flush();
			csv1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
