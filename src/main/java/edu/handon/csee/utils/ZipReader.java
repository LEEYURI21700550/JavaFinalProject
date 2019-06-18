package edu.handon.csee.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;


import edu.handong.csee.customized.LinkedList;


public class ZipReader {

	private HashMap<String, ArrayList<String>> zip1 = new HashMap<String, ArrayList<String>>();
	private HashMap<String, ArrayList<String>> zip2 = new HashMap<String, ArrayList<String>>();
	
	
	public HashMap<String, ArrayList<String>> getZip1() {
		//Map<String, ArrayList<ArrayList<String>>> sortedZip1 = new TreeMap<String, ArrayList<ArrayList<String>>>(zip1);
		return zip1;
	}

	public HashMap<String, ArrayList<String>> getZip2() {
		return zip2;
	}


	public void readFileInZip(String path) {
		ZipFile zipFile;
		File dirFile = new File(path);
		
		File []fileList = dirFile.listFiles();
		
		try {
			
			for(File fileName : fileList) {
				String file = fileName.getName();
				
				int pos = file.lastIndexOf(".");
				String studentId = file.substring(0, pos);
				zipFile = new ZipFile(fileName.getAbsoluteFile(),"EUC-KR");
				
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

				while(entries.hasMoreElements()){
					ZipArchiveEntry entry = entries.nextElement();

					InputStream stream = zipFile.getInputStream(entry);
					
					if(entry.getName().contains("요약문")) {
						System.out.println(entry.getName());
						ExcelReader myReader = new ExcelReader();
						zip1.put(studentId, myReader.getData(stream));
					} else if(entry.getName().contains("표")) {
						System.out.println(entry.getName());
						ExcelReader myReader = new ExcelReader();
						zip2.put(studentId, myReader.getData2(stream));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
