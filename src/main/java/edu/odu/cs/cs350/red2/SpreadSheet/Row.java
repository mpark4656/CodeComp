package edu.odu.cs.cs350.red2.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import edu.odu.cs.cs350.red2.Interface.StudentPair;
import edu.odu.cs.cs350.red2.SpreadSheet.Table.TableTypes;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * <pre>
 * Row Class
 * This class represents a row in an excel sheet.
 * Each row contains cells, which have can have their own style
 * </pre>
 */
public class Row
{
	private XSSFRow row;
	
	/**
	 * A Constructor for a header row
	 * @param type <b>TableTypes</b>
	 * @param row <b>XSSFRow</b>
	 * @param headerStyle <b>XSSFCellStyle</b> 
	 */
	public Row( TableTypes type , XSSFRow row , XSSFCellStyle headerStyle )
	{
		this.row = row;
		
		// These headers are added for both sheets
		XSSFCell field1 = this.row.createCell(0);
		XSSFCell field2 = this.row.createCell(1);
		XSSFCell field3 = this.row.createCell(2);
		
		field1.setCellValue( "Student1" );
		field2.setCellValue( "Student2" );
		field3.setCellValue( "Raw Score" );
		
		field1.setCellStyle( headerStyle );
		field2.setCellStyle( headerStyle );
		field3.setCellStyle( headerStyle );

		if(type == TableTypes.REPORTS){
			XSSFCell field4 = this.row.createCell(3);

			field4.setCellValue( "Z-Score" );
			field4.setCellStyle( headerStyle );
		}

	}
	
	/**
	 * A Constructor for a data result row
	 * @param type <b>TableTypes</b>
	 * @param row <b>XSSFRow</b>
	 * @param studPair <b>StudentPair</b>
	 * @param style <b>XSSFCellStyle</b>
	 */
	public Row( TableTypes type , XSSFRow row ,  StudentPair studPair , XSSFCellStyle style )
	{
		this.row = row;

		// Entries added for both table types
		XSSFCell field1 = this.row.createCell(0);
		XSSFCell field2 = this.row.createCell(1);
		XSSFCell field3 = this.row.createCell(2);

		field1.setCellValue( studPair.getFirstStudentName() );
		field1.setCellStyle(style);

		field2.setCellValue( studPair.getSecondStudentName() );
		field2.setCellStyle(style);

		field3.setCellValue( studPair.getRawScore() );
		field3.setCellStyle(style);


		if(type == TableTypes.REPORTS){
			XSSFCell field4 = this.row.createCell(3);

			field4.setCellValue( studPair.getZScore() );
			field4.setCellStyle(style);
		}
	}
	
}