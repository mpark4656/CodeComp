package edu.odu.cs.cs350.red2.SpreadSheet;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import edu.odu.cs.cs350.red2.Interface.StudentPair;

/**
 * <pre>
 * Table Class
 * This class represents a sheet in the excel workbook
 * </pre>
 */
public class Table implements Cloneable
{
	private XSSFSheet sheet;
	private TableTypes type;
	private ArrayList<Row> rows;
	private int rowCount;
	
	public enum TableTypes {
		RAWSCORES, REPORTS;
	}
	
	public Table( XSSFSheet sheet , TableTypes type )
	{
		this.sheet = sheet;
		this.type = type;
		this.rows = new ArrayList<Row>();
		
		// Add a header

			Row header = new Row( this.type , this.sheet.createRow(0) );
			rows.add(header);

		
		rowCount = 1;
	}
	
	public Table( Table toCopy )
	{
		// Not Implemented
	}
	
	public void addRow( StudentPair studPair , XSSFCellStyle style )
	{
		// type is the current table type

		Row newRow = new Row( type, sheet.createRow(rowCount) , studPair , style );
		rows.add(newRow);

		
		rowCount++;
	}
	
	@Override
	public Object clone()
	{
		// Not Implemented
		return null;
	}
	
	@Override
	public String toString()
	{
		// Not Implemented
		return null;
	}
	
	@Override
	public int hashCode()
	{
		return 0;
		// Not Implemented
	}
	
	@Override
	public boolean equals( Object obj )
	{
		// Not Implemented
		return false;
	}
}