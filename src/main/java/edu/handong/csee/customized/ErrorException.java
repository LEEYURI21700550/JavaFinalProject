package edu.handong.csee.customized;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ErrorException extends Exception{
	ArrayList<String> fileName;
	public ErrorException()
	{
		super("Error exist");
	}
	public ErrorException(ArrayList<String> filelist)
	{
		super("Error exist");
		fileName = filelist;
		
	}
	
	public void set() 
	{
		try {
		File excelName = new File("error.csv");
		if(!excelName.exists()) {			
			excelName.createNewFile();
			
		}
	
			PrintWriter outputStream= null;
			outputStream = new PrintWriter("error.csv");	
			for(String file : fileName)
			{
				outputStream.println(file);
			}


			outputStream.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
