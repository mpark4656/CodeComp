package edu.odu.cs.cs350.red2.SpreadSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Workbook
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
		rawScores = new Table( wb.createSheet( "rawScores" ) );
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
	

	
	public File getTemplate()
	{
		return template;
	}
	
	public String getSheetName()
	{
		return sheetName;
	}
}



