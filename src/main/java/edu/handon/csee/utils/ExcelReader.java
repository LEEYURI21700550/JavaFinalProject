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

import edu.handong.csee.customized.LinkedList;


public class ExcelReader {
	public ArrayList<ArrayList<String>> getData(InputStream is) {
		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		
		
		
		try (InputStream inp = is) {
		    
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        CellStyle cs = wb.createCellStyle();
		        cs.setWrapText(true);
		        
		        Iterator<Row> iterator = sheet.iterator();
		        int rows = sheet.getPhysicalNumberOfRows();
		        for(int row = 1; row<rows; row++) {
		        	Row currentRow = sheet.getRow(row);
		        	//Iterator<Cell> cellIterator = currentRow.iterator();
		        	
		        	ArrayList<String> rowData = new ArrayList<String>();
		        	
		        	int cells = currentRow.getPhysicalNumberOfCells();
		        	
		        	for(int cell = 0; cell < cells; cell++) {
		        		
		        		Cell currentCell = currentRow.getCell(cell);
		        		//currentCell.setCellStyle(cs);
		        		String data = "";
		        		if(currentCell == null) continue;
		        		else {
		        			switch(currentCell.getCellType()) {
		        			case FORMULA:
		                        data=currentCell.getCellFormula();
		                        break;
		                    case NUMERIC:
		                    	data=currentCell.getNumericCellValue()+"";
		                        break;
		                    case STRING:
		                    	data=currentCell.getStringCellValue()+"";
		                        break;
		                    case BLANK:
		                    	data=currentCell.getBooleanCellValue()+"";
		                        break;
		                    case ERROR:
		                    	data=currentCell.getErrorCellValue()+"";
		                        break;


	
		        			}
		        		}
		        		
		        		rowData.add(data);
		        	}
		        	
		        	values.add(rowData);
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

