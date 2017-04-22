package edu.odu.cs.cs350.red2.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import edu.odu.cs.cs350.red2.Interface.StudentPair;
import edu.odu.cs.cs350.red2.SpreadSheet.Table.TableTypes;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Workbook implements Cloneable
{
	private XSSFWorkbook wb;
	private WorkbookTypes type;
	private File template;
	private String sheetName;
	
	private Table rawScores;
	private Table report;
	
	XSSFCellStyle redBackground;
	XSSFCellStyle yellowBackground;
	XSSFCellStyle whiteBackground;
	XSSFCellStyle header;
	
	public enum WorkbookTypes{
		NEW, TEMPLATE;
	}
	
	public Workbook()
	{
		type = WorkbookTypes.NEW;
		sheetName = "";
		template = null;
		wb = new XSSFWorkbook();

		initializeCellStyles();
		
		rawScores = new Table( wb.createSheet("RawScores") , TableTypes.RAWSCORES );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS );
	}
	
	public Workbook( String sheetName )
	{
		type = WorkbookTypes.NEW;
		this.template = null;
		this.sheetName = sheetName;
		wb = new XSSFWorkbook();

		initializeCellStyles();
		
		rawScores = new Table( wb.createSheet(sheetName) , TableTypes.RAWSCORES );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS );
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

		initializeCellStyles();

		rawScores = new Table( wb.getSheet("rawScores") , TableTypes.RAWSCORES );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS );
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

		initializeCellStyles();
		
		rawScores = new Table( wb.getSheet(sheetName) , TableTypes.RAWSCORES );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS );
	}

	private void initializeCellStyles() {

		redBackground = wb.createCellStyle();
		yellowBackground = wb.createCellStyle();
		whiteBackground = wb.createCellStyle();
		header = wb.createCellStyle();

		// Set Styles for Red Cells
		redBackground.setFillForegroundColor(new XSSFColor(Color.RED));
		redBackground.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		redBackground.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		redBackground.setBorderTop(XSSFCellStyle.BORDER_THIN);
		redBackground.setBorderRight(XSSFCellStyle.BORDER_THIN);
		redBackground.setBorderLeft(XSSFCellStyle.BORDER_THIN);

		// Set Styles for Yellow Cells
		yellowBackground.setFillForegroundColor(new XSSFColor(Color.YELLOW));
		yellowBackground.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		yellowBackground.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderTop(XSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderRight(XSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderLeft(XSSFCellStyle.BORDER_THIN);

		// Set styles for white cells
		whiteBackground.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderTop(XSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderRight(XSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderLeft(XSSFCellStyle.BORDER_THIN);

	}
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

	public void addStudentPair(StudentPair studPair) {
		addRowToRawScores(studPair);
		addRowToReports(studPair);
	}

	private void addRowToRawScores(StudentPair studPair  )
	{
		rawScores.addRow(studPair , whiteBackground );
	}

	private void addRowToReports( StudentPair studPair )
	{
		if(studPair.getZScore() < 2.35)
			report.addRow(studPair , whiteBackground );
		else if (studPair.getZScore() < 3.1)
			report.addRow(studPair , yellowBackground );
		else
		report.addRow(studPair , redBackground );
	}
	
	public void writeWorkbookToFile( FileOutputStream outputStream )
	{
//		FileOutputStream out = null;
		
		try {
//			out = new FileOutputStream(new File( outputDirectory.getPath(), "results.xlsx"));
			wb.write(outputStream);
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nResults written to Microsoft Excel Successfully");
	}

	public void isFileAvailable(){

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
	
	@Override
	public int hashCode()
	{
		// Not Implemented
		return 0;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		return false;
	}
}



