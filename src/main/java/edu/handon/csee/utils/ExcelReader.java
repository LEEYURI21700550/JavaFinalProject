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
	public ArrayList<String> getData(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		
		
		
		try (InputStream inp = is) {
		    /*
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		     
		        
		        Iterator<Row> iterator = sheet.iterator();
		        iterator.next();
		        
		        while(iterator.hasNext()) {
		        	Row currentRow = iterator.next();
		        	Iterator<Cell> cellIterator = currentRow.cellIterator();
		        	String data=new String();
		        	
		        	while(cellIterator.hasNext()) {
		        		Cell currentCell = cellIterator.next();
		        		
		        		switch(currentCell.getCellType()) {
	        			//case FORMULA:
	                      //  data=currentCell.getCellFormula();
	                      //  break;
	                    case NUMERIC:
	                    	data += currentCell.getNumericCellValue()+"#";
	                        break;
	                    case STRING:
	                    	data += currentCell.getStringCellValue()+"#";
	                        break;
	                    case BLANK:
	                    	data+=""+"#";
	                        break;
	                   // case ERROR:
	                    //	data+=""+"^";
	                      //  break;

	        			}
		        	}
		        	values.add(data);
		        }
		        
		        */
			Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        int rows = sheet.getPhysicalNumberOfRows();
		        System.out.println(rows);
		        for(int row = 1; row<rows; row++) {
		        	Row currentRow = sheet.getRow(row);
		        	//Iterator<Cell> cellIterator = currentRow.iterator();
		        	
		        	//ArrayList<String> rowData = new ArrayList<String>();
		        	
		        	int cells = currentRow.getPhysicalNumberOfCells();
		        	String data = "";
		        	for(int cell = 0; cell < 7; cell++) {
		        		
		        		Cell currentCell = currentRow.getCell(cell);
		        		//currentCell.setCellStyle(cs);
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
	                    
		        		
		        		/*
		        			switch(currentCell.getCellType()) {
		        			//case FORMULA:
		                      //  data=currentCell.getCellFormula();
		                      //  break;
		                    case NUMERIC:
		                    	data += currentCell.getNumericCellValue()+"#";
		                        break;
		                    case STRING:
		                    	data += currentCell.getStringCellValue()+"#";
		                        break;
		                    case null;
		                    	data
		                    case BLANK:
		                    	data+=""+"#";
		                        break;
		                   // case ERROR:
		                    //	data+=""+"^";
		                      //  break;
	
		        			}
		        		*/
		        		
		        	}
		        	//System.out.println(data);
		        	values.add(data);
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
	
	
	public ArrayList<String> getData2(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		
		
		
		try (InputStream inp = is) {
		    /*
			 Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		     
		        
		        Iterator<Row> iterator = sheet.iterator();
		        iterator.next();
		        
		        while(iterator.hasNext()) {
		        	Row currentRow = iterator.next();
		        	Iterator<Cell> cellIterator = currentRow.cellIterator();
		        	String data=new String();
		        	
		        	while(cellIterator.hasNext()) {
		        		Cell currentCell = cellIterator.next();
		        		
		        		switch(currentCell.getCellType()) {
	        			//case FORMULA:
	                      //  data=currentCell.getCellFormula();
	                      //  break;
	                    case NUMERIC:
	                    	data += currentCell.getNumericCellValue()+"#";
	                        break;
	                    case STRING:
	                    	data += currentCell.getStringCellValue()+"#";
	                        break;
	                    case BLANK:
	                    	data+="  "+"#";
	                        break;
	                   // case ERROR:
	                    //	data+=""+"^";
	                      //  break;

	        			}
		        	}
		        	System.out.println(data);
		        	values.add(data);
		        }
			*/
			
			
			
			
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        CellStyle cs = wb.createCellStyle();
		        cs.setWrapText(true);
		        
		        //Iterator<Row> iterator = sheet.iterator();
		        int rows = sheet.getPhysicalNumberOfRows();
		        System.out.println(rows);
		        for(int row = 2; row<rows; row++) {
		        	Row currentRow = sheet.getRow(row);
		        	//Iterator<Cell> cellIterator = currentRow.iterator();
		        	
		        	//ArrayList<String> rowData = new ArrayList<String>();
		        	
		        	int cells = currentRow.getPhysicalNumberOfCells();
		        	String data = "";
		        	for(int cell = 0; cell < 5; cell++) {
		        		
		        		Cell currentCell = currentRow.getCell(cell);
		        		//currentCell.setCellStyle(cs);
		        		
		        		//if(currentCell == null) continue;
		        		
		        			
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
		                    
		        			
		        			/*
		        			 * 
		        			 * switch(currentCell.getCellType()) {
		        			//case FORMULA:
		                      //  data=currentCell.getCellFormula();
		                      //  break;
		                       * 
		        			case NUMERIC:
		                    	data += currentCell.getNumericCellValue()+"#";
		                        break;
		                    case STRING:
		                    	data += currentCell.getStringCellValue()+"#";
		                        break;
		                    case null:
		                    	data+=""+"#";
		                    	break;
		                    case BLANK:
		                    	data+=""+"#";
		                        break;
		                    
		                   // case ERROR:
		                    //	data+=""+"^";
		                      //  break;
	
		        			
		        		}
		        		*/
		        	}
		        	System.out.println(data);
		        	values.add(data);
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

