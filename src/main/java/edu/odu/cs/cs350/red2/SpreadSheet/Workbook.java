package edu.odu.cs.cs350.red2.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import edu.odu.cs.cs350.red2.Interface.StudentPair;
import edu.odu.cs.cs350.red2.SpreadSheet.Table.TableTypes;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 * Workbook Class
 * This class represents an excel workbook
 * </pre>
 */
public class Workbook implements Cloneable
{
	private XSSFWorkbook wb;
	private File template;
	private String sheetName;
	
	private Table rawScores;
	private Table report;
	
	private XSSFCellStyle redBackground;
	private XSSFCellStyle yellowBackground;
	private XSSFCellStyle whiteBackground;
	private XSSFCellStyle header;
	
	/**
	 * Default Constructor that creates a new workbook with
	 * default sheet name and default template
	 */
	public Workbook()
	{
		sheetName = "";
		template = null;
		wb = new XSSFWorkbook();
		
		setCellStyles();
		
		rawScores = new Table( wb.createSheet("RawScores") , TableTypes.RAWSCORES , header );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS , header );
	}
	
	/**
	 * Constructor that creates a new workbook with a different
	 * sheet name
	 * @param sheetName <b>String</b>
	 */
	public Workbook( String sheetName )
	{
		this.template = null;
		this.sheetName = sheetName;
		wb = new XSSFWorkbook();

		setCellStyles();
		
		rawScores = new Table( wb.createSheet(sheetName) , TableTypes.RAWSCORES , header );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS , header );
	}
	
	/**
	 * Constructor that reads from an existing Excel template
	 * @param template <b>File</b>
	 */
	public Workbook( File template )
	{
		this.template = template;
		
		try {
			wb = new XSSFWorkbook( new FileInputStream( this.template ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setCellStyles();
		
		// Will throw an exception if rawScores sheet is not present
		rawScores = new Table( wb.getSheet("rawScores") , TableTypes.RAWSCORES , header );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS , header );
	}
	
	/**
	 * Constructor that reads from an existing Excel template with
	 * a different sheet name
	 * @param template <b>File</b>
	 * @param sheetName <b>String</b>
	 */
	public Workbook( File template, String sheetName )
	{
		this.template = template;
		this.sheetName = sheetName;
		
		try {
			wb = new XSSFWorkbook( new FileInputStream( this.template ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setCellStyles();
		
		rawScores = new Table( wb.getSheet(sheetName) , TableTypes.RAWSCORES , header );
		report = new Table( wb.createSheet("Report") , TableTypes.REPORTS , header );
	}
	
	/**
	 * Copy Constructor
	 * @param toCopy <b>Workbook</b>
	 */
	public Workbook( Workbook toCopy )
	{
		// Not Implemented
	}
	
	/**
	 * Private method that sets the cell styles -
	 * Is invoked in the constructor.
	 */
	private void setCellStyles()
	{
		redBackground = wb.createCellStyle();
		yellowBackground = wb.createCellStyle();
		whiteBackground = wb.createCellStyle();
		header = wb.createCellStyle();
		
		// Set Styles for Header
		XSSFFont bold = wb.createFont();
		bold.setBold( true );
		
		header.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		header.setBorderTop(XSSFCellStyle.BORDER_THIN);
		header.setBorderRight(XSSFCellStyle.BORDER_THIN);
		header.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		header.setFont( bold );
		
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
	
	/**
	 * Public method to return the template file
	 * @return <b>File</b> template
	 */
	public File getTemplate()
	{
		return template;
	}
	
	/**
	 * Public method to return the sheet name
	 * @return <b>String</b> sheet name
	 */
	public String getSheetName()
	{
		return sheetName;
	}

	/**
	 * Public method to add student pair data to the RawScores
	 * table and the Reports table
	 * @param studPair <b>StudentPair</b>
	 */
	public void addStudentPair(StudentPair studPair) {
		addRowToRawScores(studPair);
		addRowToReports(studPair);
	}

	/**
	 * Private method to add student pair data to the RawScores
	 * table
	 * @param studPair <b>StudentPair</b>
	 */
	private void addRowToRawScores(StudentPair studPair  )
	{
		rawScores.addRow(studPair , whiteBackground );
	}

	/**
	 * Private method to add student pair data to the Reports
	 * table.
	 * @param studPair <b>StudentPair</b>
	 */
	private void addRowToReports( StudentPair studPair )
	{
		if(studPair.getZScore() < 2.35)
			report.addRow(studPair , whiteBackground );
		else if (studPair.getZScore() < 3.1)
			report.addRow(studPair , yellowBackground );
		else
			report.addRow(studPair , redBackground );
	}
	
	/**
	 * Public method to write this workbook to file.
	 * @param outputStream <b>FileOutputStream</b>
	 */
	public void writeWorkbookToFile( FileOutputStream outputStream )
	{
		try {
			wb.write(outputStream);
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nResults written to Microsoft Excel Successfully");
	}
	
	/**
	 * Overrides clone() method.
	 * @return <b>Object</b> A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Workbook( this );
	}
	
	/**
	 * Overrides hashCode() method.
	 * @return <b>int</b>
	 */
	@Override
	public int hashCode()
	{
		// Not Implemented
		return 0;
	}
	
	/**
	 * Overrides equals() method.
	 * @param obj <b>Object</b> Object to compare
	 * @return <b>boolean</b> True if the two objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		return false;
	}
}



