package edu.odu.cs.cs350.red2.SpreadSheet;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import edu.odu.cs.cs350.red2.Interface.StudentPair;

/**
 * <pre>
 * <b>Table Class</b>
 * This class represents a sheet in the excel workbook.
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
	
	/**
	 * A constructor for creating a table on an Excel Spreadsheet
	 * @param sheet <b>XSSFSheet</b>
	 * @param type <b>TableTypes</b>
	 * @param headerStyle <b>XSSFCellStyle</b>
	 */
	public Table( XSSFSheet sheet , TableTypes type , XSSFCellStyle headerStyle )
	{
		this.sheet = sheet;
		this.type = type;
		this.rows = new ArrayList<Row>();
		
		// Add a header
		rows.add( new Row(this.type , this.sheet.createRow(0) , headerStyle) );
		
		// Set rowCount to 1. This variable is incremented every time a row is added
		rowCount = 1;
	}
	
	/**
	 * Copy Constructor
	 * @param toCopy <b>Table</b>
	 */
	@SuppressWarnings("unchecked")
	public Table( Table toCopy )
	{
		this.sheet = toCopy.sheet;
		this.type = toCopy.type;
		this.rows = (ArrayList<Row>)toCopy.rows.clone();
		this.rowCount = toCopy.rowCount;
	}
	
	/**
	 * A public method that adds a row to this table
	 * @param studPair <b>StudentPair</b>
	 * @param style <b>XSSFCellStyle</b>
	 */
	public void addRow( StudentPair studPair , XSSFCellStyle style )
	{
		// type is the current table type
		rows.add(new Row( type, sheet.createRow(rowCount) , studPair , style ));
		
		rowCount++;
	}
	
	/**
	 * Overrides clone() method.
	 * @return <b>Object</b> A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Table(this);
	}
	
	/**
	 * Override toString() to return the sheet name
	 * @return <b>String</b> Sheet name
	 */
	@Override
	public String toString()
	{
		return sheet.getSheetName();
	}
	
	/**
	 * Overrides hashCode() method
	 * @return <b>int</b> hash code
	 */
	@Override
	public int hashCode()
	{
		return 0;
		// Not Implemented
	}
	
	/**
	 * Overrides equals() method.
	 * @param obj <b>Object</b> Object to compare
	 * @return <b>boolean</b> True if the objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		// Not Implemented
		return false;
	}
}