package edu.odu.cs.cs350.red2.SpreadSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Table
{
	private XSSFSheet sheet;
	private String sheetName;
	
	public Table( XSSFSheet sheet )
	{
		this.sheet = sheet;
	}
}