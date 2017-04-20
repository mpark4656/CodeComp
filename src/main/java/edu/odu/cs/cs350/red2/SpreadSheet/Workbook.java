package edu.odu.cs.cs350.red2.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import edu.odu.cs.cs350.red2.Interface.StudentPair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Workbook implements Cloneable
{
	private XSSFWorkbook wb;
	private WorkbookTypes type;
	private File template;
	private String sheetName;
	
	private Table rawScores;
	private Table report;
	
	public enum WorkbookTypes{
		NEW, TEMPLATE;
	}
	
	public Workbook()
	{
		type = WorkbookTypes.NEW;
		sheetName = "";
		template = null;
		wb = new XSSFWorkbook();
		rawScores = new Table( wb.createSheet( "RawScores" ) );
		report = new Table( wb.createSheet( "Report" ) );
	}
	
	public Workbook( String sheetName )
	{
		type = WorkbookTypes.NEW;
		this.template = null;
		this.sheetName = sheetName;
		wb = new XSSFWorkbook();
		rawScores = new Table( wb.createSheet( sheetName ) );
		report = new Table( wb.createSheet( "Report" ) );
	}
	
	public Workbook( File template ) {
		type = WorkbookTypes.TEMPLATE;
		this.template = template;
		
		try {
			wb = new XSSFWorkbook( new FileInputStream( this.template ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rawScores = new Table( wb.getSheet("rawScores") );
		report = new Table( wb.createSheet("Report") );
	}
	
	public Workbook( File template, String sheetName )
	{
		type = WorkbookTypes.TEMPLATE;
		this.template = template;
		this.sheetName = sheetName;
		
		try {
			wb = new XSSFWorkbook( new FileInputStream( this.template ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rawScores = new Table( wb.getSheet(sheetName) );
		report = new Table( wb.createSheet("Report") );
	}
	
	/**
	 * Copy Constructor
	 * @param <b>toCopy</b>
	 */
	public 	Workbook( Workbook toCopy )
	{
		// Not Implemented
	}
	
	public File getTemplate()
	{
		return template;
	}
	
	public String getSheetName()
	{
		return sheetName;
	}
	
	public void addRowsToRawScores( ArrayList<StudentPair> studPairs )
	{
		// Not Implemented
	}
	
	public void addRowsToReports( ArrayList<StudentPair> studPairs )
	{
		// Not Implemented
	}
	
	public void writeWorkbookToFile( File outputDirectory )
	{
		// Not Implemented
	}
	
	@Override
	public Object clone()
	{
		return new Workbook( this );
	}
	
	@Override
	public String toString()
	{
		// Not Implemented
		return null;
	}
}



