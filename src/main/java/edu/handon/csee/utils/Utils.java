package edu.handon.csee.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import edu.handong.csee.customized.LinkedList;

public class Utils {
	
	public static void writeAFile(Map<String, LinkedList<String>> sortedZip1,Map<String, LinkedList<String>> sortedZip2, String outputPath) throws IOException {
		
		int pos = outputPath.lastIndexOf(".");
		String path = outputPath.substring(0, pos);
		String pa = outputPath.substring(pos);
		String path1 = path + 1 + pa;
		String path2 = path + 2 + pa;
		
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		file1.getParentFile().mkdirs();
		file2.getParentFile().mkdirs();
		
		BufferedWriter buffer1 = new BufferedWriter(new FileWriter(file1));
		file1.createNewFile();
		BufferedWriter buffer2 = new BufferedWriter(new FileWriter(file2));
		file2.createNewFile();
		
		
		CSVPrinter csv1 = new CSVPrinter(buffer1, CSVFormat.DEFAULT.withHeader("StudentId","제목","요약문 (300자 내외)", "핵심어\n" + 
				"(keyword,쉽표로 구분)", "조회날짜", "실제자료조회\n" + 
						"출처 (웹자료링크)", "원출처 (기관명 등)", "제작자\n" + 
								"(Copyright 소유처)" ));
		
		CSVPrinter csv2 = new CSVPrinter(buffer2, CSVFormat.DEFAULT.withHeader("StudentId", "제목(반드시 요약문 양식에 입력한 제목과 같아야 함.)",
				"표/그림 일련번호", "자료유형(표,그림,…)", "자료에 나온 표나 그림 설명(캡션)", "자료가 나온 쪽번호"));
		
		
		for(String key: sortedZip1.keySet()) {
			for(String a : sortedZip1.get(key).toArrayList()) {
					String[] splited = a.split("#");
					if(splited.length == 7)
					csv1.printRecord(key, splited[0],splited[1],splited[2],splited[3],splited[4],splited[5],splited[6]);
				}
			}
		
	
		
		for(String key: sortedZip2.keySet()) {
			for(String a : sortedZip2.get(key).toArrayList()) {
					String[] splited = a.split("#");
					if(splited.length == 5)
						csv2.printRecord(key, splited[0],splited[1],splited[2],splited[3],splited[4]);
				}
			}
		
		
		csv1.flush();
		csv1.close();
		
		csv2.flush();
		csv2.close();
		

	
	}

}
