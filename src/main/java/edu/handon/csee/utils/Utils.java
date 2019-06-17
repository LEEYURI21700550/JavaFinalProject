package edu.handon.csee.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Utils {
	
	public static void writeAFile(Map<String, ArrayList<ArrayList<String>>> sortedZip, String targetFileName) {
		
		PrintWriter outputStream= null;
		File file = new File(targetFileName);
		File AFile = file.getAbsoluteFile();
		try {
			if(!file.exists()) {
				AFile.getParentFile().mkdirs();
			}

			outputStream = new PrintWriter(targetFileName);	

		} catch (FileNotFoundException e) {
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		}
		
		
		
		for(String key: sortedZip.keySet()) {
			System.out.println(key);
			for(ArrayList<String> a : sortedZip.get(key)) {
				String result ="\"";
				for(String c: a ) {
					result = result+ c + ",";
					//System.out.println(c);
					
				}
				result+="\"";
				outputStream.println(key+","+result+",");
			}
		
		}
		
		
		
		
		//String result = new String();
		/*
		for(String key: big.keySet()) {
			//System.out.println(key);
			
			for(ArrayList<String> line : big.get(key)) {
				String result = new String();
				for(String one: line ) {
					result = result + ",";
				}
				System.out.println(result);
				outputStream.println(result);
			}
		
		}
		*/
		
		
		/*
		for(String line : lines)
		{
			outputStream.println(line);
		}

*/
		outputStream.close();

		
		
		
	
/*
		String fPath=targetFileName.replace("/",File.separator);
		int num=fPath.lastIndexOf(File.separator);
		String filePath=fPath.substring(0,num);
		File path = new File(targetFileName);
		if (!path.exists()) {
			path.mkdirs();
		}


		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		int rowNum = 0;
		for(String key: lines.keySet()) {
			for(ArrayList<String> line: lines.get(key)) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for(String data:line) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue(data);
			}
		}}try {
			FileOutputStream out = new FileOutputStream(new File(targetFileName)); 
			workbook.write(out); 
			out.close(); 
		}catch(Exception e) {
			e.getMessage();
		}
*/
	}

}
