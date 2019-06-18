package edu.handon.csee.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.handong.csee.customized.ErrorException;
import edu.handong.csee.customized.LinkedList;


public class ExcelReader {
	public LinkedList<String> getData(InputStream is) {
		LinkedList<String> values = new LinkedList<String>();
		
		
		
		try (InputStream inp = is) {
		
			Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        int rows = sheet.getPhysicalNumberOfRows();
		        //System.out.println(rows);
		        
		        for(int row = 1; row<rows; row++) {
		        	Row currentRow = sheet.getRow(row);
		        	
		        	
		        	//int cells = currentRow.getPhysicalNumberOfCells();
		        	String data = "";
		        	
		        	for(int cell = 0; cell < 7; cell++) {
		        		
		        		Cell currentCell = currentRow.getCell(cell);
		        	
		        		if(currentCell == null) {
		        			data+=""+"#";
		        		}
		        		else if(currentCell.getCellType() == CellType.NUMERIC) {
	        				data += currentCell.getNumericCellValue()+"#";
	        			} else if(currentCell.getCellType() == CellType.STRING) {
	        				data += currentCell.getStringCellValue()+"#";
	        			} else if(currentCell.getCellType() == CellType.BLANK) {
	        				data+=""+"#";
	        			}
	                    
		        		
		        	
		        	}
		        	
		        	values.addANodeToTail(data);
		        }
		        


		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return values;
	}
	
	
	public LinkedList<String> getData2(InputStream is) {
		LinkedList<String> values = new LinkedList<String>();
		
		
		
		try (InputStream inp = is) {
	
	
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        CellStyle cs = wb.createCellStyle();
		        cs.setWrapText(true);
		
		        int rows = sheet.getPhysicalNumberOfRows();
		        System.out.println(rows);
		        for(int row = 2; row<rows; row++) {
		        	Row currentRow = sheet.getRow(row);
		    
		        	
		        	int cells = currentRow.getPhysicalNumberOfCells();
		        	String data = "";
		        	
		        	for(int cell = 0; cell < 5; cell++) {
		        		
		        		Cell currentCell = currentRow.getCell(cell);
		        	
		        		
		        			
		        			if(currentCell == null ) {
		        				data+=""+"#";
		        			}
		        		else if(currentCell.getCellType() == CellType.NUMERIC) {
		        				data += currentCell.getNumericCellValue()+"#";
		        			} else if(currentCell.getCellType() == CellType.STRING) {
		        				data += currentCell.getStringCellValue()+"#";
		        			} else if(currentCell.getCellType() == CellType.BLANK) {
		        				data+=""+"#";
		        			}
		                    
		        			
		        			
		        	}
		        	System.out.println(data);
		        	values.addANodeToTail(data);
		        }
		        


		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		

		return values;
	}

}

