package edu.odu.cs.cs350.red2.SpreadSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import edu.odu.cs.cs350.red2.Interface.StudentPair;

public class Table implements Cloneable
{
	private XSSFSheet sheet;
	private TableTypes type;
	
	public enum TableTypes {
		RAWSCORES, REPORTS;
	}
	
	public Table( XSSFSheet sheet , TableTypes type )
	{
		this.sheet = sheet;
		this.type = type;
	}
	
	/**
	 * Copy Constructor
	 */
	public Table( Table toCopy )
	{
		// Not Implemented
	}
	
	public void addRow( StudentPair studPair )
	{
		// Not Implemented
	}
	
	
	
}