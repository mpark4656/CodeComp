package edu.odu.cs.cs350.red2.SpreadSheet;

import java.awt.Color;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;

import edu.odu.cs.cs350.red2.Interface.StudentPair;
import edu.odu.cs.cs350.red2.SpreadSheet.Table.TableTypes;

import org.apache.poi.xssf.usermodel.XSSFCell;

// Create the second row
//row = sheet.createRow(1);

/*
// Create the first cell in the second row and set the value to "This"
cell = row.createCell(0);
cell.setCellValue("This");
cell.setCellStyle( yellowBackground );
*/
public class Row
{
	private XSSFRow row;
	
	public Row( TableTypes type , XSSFRow row )
	{
		this.row = row;
		
		if( type == TableTypes.RAWSCORES ) {
			XSSFCell field1 = this.row.createCell(0);
			XSSFCell field2 = this.row.createCell(1);
			XSSFCell field3 = this.row.createCell(2);
			
			field1.setCellValue( "Student1" );
			field2.setCellValue( "Student2" );
			field3.setCellValue( "RawScores" );
		}
	}
	
	public Row( TableTypes type , XSSFRow row ,  StudentPair studPair , XSSFCellStyle style )
	{
		this.row = row;
		
		if( type == TableTypes.RAWSCORES ) {
			XSSFCell field1 = this.row.createCell(0);
			XSSFCell field2 = this.row.createCell(1);
			XSSFCell field3 = this.row.createCell(2);
			
			field1.setCellValue( studPair.getFirstStudentName() );
			field1.setCellStyle(style);
			
			field2.setCellValue( studPair.getSecondStudentName() );
			field2.setCellStyle(style);
			
			field3.setCellValue( studPair.getRawScore() );
			field3.setCellStyle(style);
		}
	}
	
}