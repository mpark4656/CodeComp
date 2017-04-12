package edu.odu.cs.cs350.red2.Interface;

import edu.odu.cs.cs350.codeCompCommon.SharedPhrases;
import edu.odu.cs.cs350.red2.FileFilter.DirectoryFilter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * <pre>
 * <b>Instructor Class</b>
 * 
 * This class serves as the main interface for CodeComp.
 * The operations of this class attempt to mirror the actions of 
 * a real-life instructor who is reading through student codes to
 * see if any of them cheated by copying another student's codes.
 * 
 * This class will invoke various methods from the sub-interfaces:
 * Student, StudentPair, Submission
 * </pre>
 */
public class Instructor implements Cloneable
{
	
	// List of all students in this instructor's class
	private ArrayList<Student>  students;
	
	// List of all possible Student Pairs
	private ArrayList<StudentPair> stuPairs;
	
	// Check command-line arguments
	private boolean templateSpecified;
	private boolean sheetNameSpecified;
	
	// Unless user provided optional arguments, these are empty strings
	private String template;
	private String sheetName;
	
	// These boolean variables will serve as preconditions for some methods
	// These should be initialized to false when Instructor is first instantiated
	private boolean receivedSubmissions;
	private boolean parsedStudentSubmissions;
	private boolean analyzedTokenSequences;
	
	// Stores output directory path
	private File outputDirectory;
	
	/**
	 * <pre>
	 * Constructor
	 * The submission directory will be obtained via acceptStudentSubmissions(), 
	 * so the submission directory path is not one of the parameters of this constructor.
	 * </pre>
	 * @param outputSpreadsheet <b>String</b>
	 */
	public Instructor( String outputSpreadsheet)
	{
		students = new ArrayList<Student> ();
		stuPairs = new ArrayList<StudentPair> ();
		
		templateSpecified = false;
		sheetNameSpecified = false;
		
		receivedSubmissions = false;
		parsedStudentSubmissions = false;
		analyzedTokenSequences = false;
		
		outputDirectory = new File( outputSpreadsheet );
		
		template = "";
		sheetName = "";
	}
	
	
	/**
	 * Copy Constructor
	 * @param obj <b>Instructor</b>
	 */
	@SuppressWarnings("unchecked")
	public Instructor( Instructor obj )
	{
		this.students = (ArrayList<Student>) obj.students.clone();
		this.stuPairs = (ArrayList<StudentPair>) obj.stuPairs.clone();
		this.templateSpecified = obj.templateSpecified;
		this.sheetNameSpecified = obj.sheetNameSpecified;
		this.receivedSubmissions = obj.receivedSubmissions;
		this.parsedStudentSubmissions = obj.parsedStudentSubmissions;
		this.analyzedTokenSequences = obj.analyzedTokenSequences;
		this.outputDirectory = new File( obj.outputDirectory.getPath() );
		this.template = new String( obj.template );
		this.sheetName = new String( obj.sheetName );
	}
	
	/**
	 * Public method that returns true if the instructor specified a template
	 * @return <b>boolean</b> -  Return true if this instructor specified a template.
	 */
	public boolean isTemplateSpecified()
	{
		return templateSpecified;
	}
	
	/**
	 * Public method that returns true if this instructor specified a sheet name
	 * @return <b>boolean</b> - Return true if this instructor specified a sheet name.
	 */
	public boolean isSheetNameSpecified()
	{
		return sheetNameSpecified;
	}
	
	/**
	 * <pre>
	 * Public method that returns the name of the template as String.
	 * If a template has not been specified, it will return an empty string.
	 * </pre>
	 * @return <b>String</b> - The template name
	 */
	public String getTemplate()
	{
		return template;
	}
	
	/**
	 * <pre>
	 * Public method that returns the name of the sheet name as String.
	 * If a sheet name has not been specified, it will return an empty string.
	 * </pre>
	 * @return <b>String</b> - The sheet name
	 */
	public String getSheetName()
	{
		return sheetName;
	}
	
	/**
	 * Public method that sets the template name
	 * @param template <b>String</b>
	 */
	public void setTemplate( String template )
	{
		this.template = template;
		
		templateSpecified = true;
	}
	
	/**
	 * Public method that sets the sheet name
	 * @param sheetName <b>String</b>
	 */
	public void setSheetName( String sheetName )
	{
		this.sheetName = sheetName;
		
		sheetNameSpecified = true;
	}
	
	/**
	 * Public method that returns true if this instructor received student submissions
	 * @return <b>boolean</b> - Return true if this instructor accepted student submissions
	 */
	public boolean isSubmissionReceived()
	{
		return receivedSubmissions;
	}
	
	/**
	 * Public method that returns true if student codes have been parsed
	 * @return <b>boolean</b> - Return true if this instructor parsed students' codes.
	 */
	public boolean isSubmissionParsed()
	{
		return parsedStudentSubmissions;
	}
	
	/**
	 * <pre>
	 * Public method that returns true if token sequences have been analyzed.
	 * The products of token sequence analysis are raw scores and z-scores.
	 * </pre>
	 * @return <b>boolean</b> - Return true if raw scores and z-scores have been calculated
	 */
	public boolean isTokenSequenceAnalyzed()
	{
		return analyzedTokenSequences;
	}
	
	/**
	 * <pre>
	 * Return the Student object for the given identifier.
	 * If not found, it will return null.
	 * </pre>
	 * @param identifier <b>String</b> identifier
	 * @return <b>Student</b> The student object that corresponds to the identifier
	 */
	public Student getStudent( String identifier )
	{
		// Iterate through Student ArrayList and find student item with the same identifier
		for( int i = 0 ; i < students.size(); i++ ) {
			
			// If the same identifier student obj is found, return it.
			if( students.get(i).toString().equals(identifier) ) {
				return students.get(i);
			}
		}
		
		// Student Identifier Not Found, return null.
		return null;
	}
	
	/**
	 * <pre>
	 * Public method that returns Student Pair object.
	 * If the specified pair is not found, it will return null.
	 * The returned student pair object sorts the student objects.
	 * For example, if Nathan and Mike are searched, the returned object
	 * will have Mike as the first student and Nathan as the second student
	 * because 'M' precedes 'N'. However, it's not required that user sorts
	 * the parameters.
	 * </pre>
	 * @param stud1 <b>String</b> Name of First Student
	 * @param stud2 <b>String</b> Name of Second Student
	 * @return <b>StudentPair</b> - Specified pair object
	 */
	public StudentPair getStudentPair( String stud1 , String stud2 )
	{
		for( StudentPair pair : stuPairs ) {
			if( stud1.equals(pair.getFirstStudentName()) &&
				stud2.equals(pair.getSecondStudentName()) ) {
				
				return pair;
			}
			
			if( stud1.equals(pair.getSecondStudentName()) &&
				stud2.equals(pair.getFirstStudentName()) ) {
				
				return pair;
			}
		}
		
		return null;
	}
	
	/**
	 * Public method that returns the total number of students from whom
	 * this instructor received submissions
	 * @return <b>int</b> - Total Number of Students that submissted their codes
	 */
	public int getTotalStudentCount()
	{
		return students.size();
	}
	
	/**
	 * <pre>
	 * Public method that returns the total number of student pairs.
	 * 
	 * Example:
	 * Given 5 students, { 1 , 2 , 3 , 4 , 5 }
	 * Ten student pairs are created.
	 * { 1 , 2 }
	 * { 1 , 3 }
	 * { 1 , 4 }
	 * { 1 , 5 }
	 * { 2 , 3 }
	 * { 2 , 4 }
	 * { 2 , 5 }
	 * { 3 , 4 }
	 * { 3 , 5 }
	 * { 4 , 5 }
	 * </pre>
	 * @return <b>int</b> - Total number of student pairs
	 */
	public int getTotalStudentPairCount()
	{
		return stuPairs.size();
	}
	
	/**
	 * <pre>
	 * Public method that accepts student submissions
	 * Precondition: receivedSubmissions == false
	 * Postcondition: receivedSubmissions == true
	 * </pre>
	 * @param submissionDirectory <b>File</b>
	 * @return <b>boolean</b> - Return true if this operation was successfully completed
	 */
	public boolean acceptStudentSubmissions( File submissionDirectory )
	{
		// If this instructor already received submissions, return true.
		if( receivedSubmissions ) {
			return true;
		}
		
		// If this is not a directory/folder, return.
		if( !submissionDirectory.isDirectory() ) {
			return false;
		}
		
		// Store a list of files in the submission directory
		// Apply the Directory Filter to ignore any non-directory files.
		File[] directoryFiles = submissionDirectory.listFiles(new DirectoryFilter());
				
		// Iterate through all files in the parent directory. 
		for( int i = 0 ; i < directoryFiles.length ; i++ ) {
			
			// Get the folder name
			// Examples:
			// Mike.1
			// Mike
			// Mike.2
			String folderName = directoryFiles[i].getName();
			//System.out.println( "Debugging: The folder name is " + folderName );
			
			// Get the identifier
			// Example:
			// Mike
			String id = "";
			
			// If the folder name contains . get the substring (Only the identifier portion)
			if( folderName.contains(".") ) {
				id = folderName.substring( 0, folderName.indexOf('.') );
			}
			// If the folder name does not contain . the entire string is identifier.
			else {
				id = folderName;
			}
			
			//System.out.println( "Debugging: The id is " + id );
			
			// Check to see if this student already exists in the collection
			if( getStudent(id) != null ) { // Student ID already exists
				
				// Since ID already exists, find the student and add this submission
				for( int j = 0 ; j < students.size(); j++ ) {
					if( students.get(j).toString().equals(id) ) {
						students.get(j).addSubmission( directoryFiles[i] );
					}
				}
			}
			// This is a student with new ID, add it to the collection and then add submission
			// Also, add Student Pair
			else {

				Student newStudent = new Student( id );
				
				newStudent.addSubmission( directoryFiles[i] );
				
				for( int index = 0 ; index < students.size() ; index++) {
					stuPairs.add( new StudentPair(newStudent , students.get(index)) );
				}

				students.add( newStudent );
			}
		}
		
		// Debugging Output
		/*
		for( int i = 0 ; i < students.size(); i++ ) {
			System.out.println( "Debugging: Student " + (i + 1) + ": " + students.get(i).toString() );
		}
		*/
		
		receivedSubmissions = true;
		return receivedSubmissions;
	}
	
	/**
	 * <pre>
	 * Public method that prints feedback output.
	 * The feedback output consists of student identifier, total number of code files,
	 * estimated number of LOC.
	 * 
	 * If this method is invoked when submissions have not been received, it will do nothing.
	 * Precondition: receivedSubmissions == true
	 * </pre>
	 */
	public void outputFeedback()
	{
		// Can't produce output if submissions have not been received.
		if( !receivedSubmissions ) {
			return;
		}
		
		// Sort student objects, so the identifiers appear in ascending order.
		students.sort( null );
		
		System.out.println( "\nFound " + students.size() + " student submissions:\n");

		// Iterate through every student in this instructor's class
		for (int i = 0; i < students.size(); i++)
		{
			// The number of lines and the number of files can be obtained by invoking
			// getTotalCodeFileCount() and getTotalCodeLineCount() on each student object.
			System.out.print( students.get(i) + "\t\tFiles: " + students.get(i).getTotalCodeFileCount() );
			System.out.println( "\t\t" + "LOC: " + students.get(i).getTotalCodeLineCount() );															
		}
		
		if( students.size() == 0 ) {
			System.out.println( "\nFinished" );
		}
		else if( stuPairs.size() == 0 ) {
			System.out.println( "\nRequires at least 2 student submissions for analysis" );
		}
		else {
			System.out.println( "\nAnalyzing codes ...");
			System.out.println( "This may take a while.");
			System.out.println();
		}
	}
	
	/**
	 * <pre>
	 * Public method that parses student submissions.
	 * The product of this operation is sequences of tokens.
	 * 
	 * Precondition: receivedSubmissions == true and parsedStudentSubmissions == false
	 * Postcondition: parsedStudentSubmissions == true
	 * </pre>
	 * @return <b>boolean</b> - Return true if the submissions were successfully parsed.
	 */
	public boolean parseSubmissions()
	{
		// If the submissions are already parsed, return true
		if( parsedStudentSubmissions == true ) {
			return true;
		}
		
		// If submissions have not been received, return false
		if( receivedSubmissions == false ) {
			return false;
		}
		
		// Iterate through all students
		for( int i = 0 ; i < students.size(); i++ ) {
			
			// If a student submission fails to tokenize, return false/
			if( !students.get(i).getPrioritySubmission().tokenize() ) {
				return false;
			}
		}
		
		// Debugging Output
		/*
		System.out.println();
		for( Student stud : students ) {
			System.out.println( stud.toString() + "\nToken Length: " + stud.getTokenSequenceLength() );
			System.out.println( stud.getTokenSequence() );
			System.out.println();
		}
		*/
		
		// If the control reaches here, that means all student submissions were successfully
		// parsed.
		parsedStudentSubmissions = true;
		return parsedStudentSubmissions;
	}
	
	/**
	 * <pre>
	 * Analyze similarity and calculate the raw score and the z-score for every student pair.
	 * 
	 * Precondition: parsedStudentSubmissions == true and analyzedTokenSequences == false
	 * Postcondition: analyzedTokenSequences == true
	 * </pre>
	 * @return <b>boolean</b> - Return true if the token sequences were successfully analyzed.
	 */
	public boolean analyze()
	{
		// If this instructor already analyzed token sequences, return true
		if( analyzedTokenSequences ) {
			return true;
		}
		
		// If the submissions have not been parsed, they need to be parsed first.
		if( parsedStudentSubmissions == false ) {
			return false;
		}
		
		// If there is no student pairs, there is nothing to analyze, return true
		if( stuPairs.size() == 0 ) {
			return true;
		}
		
		// Sort the student pairs
		stuPairs.sort( null );
		
		// Create SharedPhrases object - this will store token sequences of all students
		SharedPhrases phrases = new SharedPhrases();
		
		// Add each student's token sequence to phrases
		for( Student stud : students ) {
			phrases.addSentence( stud.getTokenSequence().toString() , stud.toString() );
		}
		
		int start = 1;
		int end = stuPairs.size();
		
		// Iterate through every student pair and calculate the raw score
		// Formula for T: len(p) / (k - 1)^2
		//  , where p is a shared phrase and k is the total number of students sharing the phrase
		for( StudentPair studPair : stuPairs ) {
			System.out.print( start + " of " + end );
			
			double T = 0;
			
			// Calculate T
			for( CharSequence phrase : phrases.allPhrases() ) {
				if( phrases.sourcesOf(phrase.toString()).contains(studPair.getFirstStudentName()) && 
					phrases.sourcesOf(phrase.toString()).contains(studPair.getSecondStudentName()) ) {
					
					int k = phrases.sourcesOf(phrase.toString()).size();
					double toAdd = phrase.length() / Math.pow( (k - 1), 2.0 );
					T = T + toAdd;
				}
			}
			
			studPair.calculateRawScore( T );
			
			System.out.println( " COMPLETED");
			start ++;
		}
		
		double rawScoreAverage = calculateRawScoreAverage();
		
		System.out.println();
		System.out.println( "\n\nRESULTS:\n" );
		int index = 1;
		
		// Iterate through every student pair and calculate the z-score
		for( StudentPair studPair : stuPairs ) {
			studPair.calculateZScore( rawScoreAverage , calculateStandardDev( rawScoreAverage ) );
			
			System.out.println( index + ". Scores for " + studPair );
			System.out.println( "Raw Score: " + String.format("%.2f", studPair.getRawScore()) + 
								"\nZ-Score: " + String.format("%.2f", studPair.getZScore()) );
			System.out.println();
			index ++;
		}
		
		analyzedTokenSequences = true;
		return analyzedTokenSequences;
	}
	
	/**
	 * Private method that calculates the average raw score
	 * @return <b>double</b> The average raw score
	 */
	private double calculateRawScoreAverage()
	{
		double rawScoreAverage = 0;
		
		for( StudentPair studPair : stuPairs ) {
			rawScoreAverage += studPair.getRawScore();
		}
		
		rawScoreAverage = rawScoreAverage / stuPairs.size();
		
		return rawScoreAverage;
	}
	
	/**
	 * <pre>
	 * Private method that calculates the standard deviation.
	 * 
	 * Formula: sqrt( sum( (average - individualScore)^2 ) / TotalCount ) 
	 * </pre>
	 * @param averageRawScore <b>double</b> Average raw score
	 * @return <b>double</b> - The standard deviation
	 */
	private double calculateStandardDev( double averageRawScore )
	{
		double standardDeviation = 0;
		double sigma = 0;
		
		// Iterate through every student pair and calculate the standard deviation
		for( StudentPair studPair : stuPairs ) {
			sigma += Math.pow( studPair.getRawScore() - averageRawScore , 2.0 );
		}
		
		standardDeviation = Math.sqrt( sigma / stuPairs.size() );
		
		return standardDeviation;
	}
	
	/**
	 * Generate and write result tables to Excel spreadsheet
	 */
	public void displayResult()
	{
		// Not Implemented
		writeToFile();
	}
	
	/**
	 * Private method that writes a table to Excel spreadsheet
	 */
	private void writeToFile()
	{
		//**********************************************************************
		//             This is a demonstration of Apache POI
		//**********************************************************************
		 
		// Get the workbook instance for XLS file 
		HSSFWorkbook workbook = new HSSFWorkbook();

		// Create a sheet named RawScores in the workbook
		HSSFSheet sheet = workbook.createSheet( "RawScores" );
		
		// Create the first row
		Row row = sheet.createRow(0);
		
		// Create Red Background Style with Border
		HSSFCellStyle redBackground = workbook.createCellStyle();
		redBackground.setFillForegroundColor(HSSFColor.RED.index);
		redBackground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		redBackground.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		redBackground.setBorderTop(HSSFCellStyle.BORDER_THIN);
		redBackground.setBorderRight(HSSFCellStyle.BORDER_THIN);
		redBackground.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		
		// Create Yellow Background Style with Border
		HSSFCellStyle yellowBackground = workbook.createCellStyle();
		yellowBackground.setFillForegroundColor(HSSFColor.YELLOW.index);
		yellowBackground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		yellowBackground.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderTop(HSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderRight(HSSFCellStyle.BORDER_THIN);
		yellowBackground.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		
		// Create White Background Style with Border
		HSSFCellStyle whiteBackground = workbook.createCellStyle();
		whiteBackground.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderTop(HSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderRight(HSSFCellStyle.BORDER_THIN);
		whiteBackground.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		
		// Create the first cell in the first row and set the value to "This"
		Cell cell = row.createCell(0);
		cell.setCellValue("This");
		cell.setCellStyle( redBackground );
		
		// Create the second cell in the first row and set the value to "Is"
		cell = row.createCell(1);
		cell.setCellValue("Is");
		cell.setCellStyle( redBackground );
		
		// Create the third cell in the first row and set the value to "A"
		cell = row.createCell(2);
		cell.setCellValue("A");
		cell.setCellStyle( redBackground );
		
		// Create the fourth cell in the first row and set the value to "First"
		cell = row.createCell(3);
		cell.setCellValue("First");
		cell.setCellStyle( redBackground );
		
		// Create the fifth cell in the first row and set the value to "Test"
		cell = row.createCell(4);
		cell.setCellValue("Test");
		cell.setCellStyle( redBackground );
		
		// Create the second row
		row = sheet.createRow(1);
		
		// Create the first cell in the second row and set the value to "This"
		cell = row.createCell(0);
		cell.setCellValue("This");
		cell.setCellStyle( yellowBackground );
		
		// Create the second cell in the second row and set the value to "Is"
		cell = row.createCell(1);
		cell.setCellValue("Is");
		cell.setCellStyle( yellowBackground );
		
		// Create the third cell in the second row and set the value to "A"
		cell = row.createCell(2);
		cell.setCellValue("A");
		cell.setCellStyle( yellowBackground );
		
		// Create the fourth cell in the second row and set the value to "Second"
		cell = row.createCell(3);
		cell.setCellValue("Second");
		cell.setCellStyle( yellowBackground );
		
		// Create the fifth cell in the second row and set the value to "Test"
		cell = row.createCell(4);
		cell.setCellValue("Test");
		cell.setCellStyle( yellowBackground );
		
		// Create the third row
		row = sheet.createRow(2);
		
		// Create the first cell in the third row and set the value to "This"
		cell = row.createCell(0);
		cell.setCellValue("This");
		cell.setCellStyle( whiteBackground );
		
		// Create the second cell in the third row and set the value to "Is"
		cell = row.createCell(1);
		cell.setCellValue("Is");
		cell.setCellStyle( whiteBackground );
		
		// Create the third cell in the third row and set the value to "A"
		cell = row.createCell(2);
		cell.setCellValue("A");
		cell.setCellStyle( whiteBackground );
		
		// Create the fourth cell in the third row and set the value to "Third"
		cell = row.createCell(3);
		cell.setCellValue("Third");
		cell.setCellStyle( whiteBackground );
		
		// Create the fifth cell in the third row and set the value to "Test"
		cell = row.createCell(4);
		cell.setCellValue("Test");
		cell.setCellStyle( whiteBackground );
				
		// Write the results to the Excel file
		try {
			FileOutputStream out = new FileOutputStream(new File("src/test/data/testOutputDirectory/Reports.xls"));
			workbook.write(out);
			out.close();
			System.out.println("\nResults written to Microsoft Excel Successfully");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//**********************************************************************
		//             End of Apache POI Demonstration
		//**********************************************************************
	}
	
	/**
	 * Override toString() method to return the output directory name as String
	 * @return <b>String</b> - Output directory name
	 */
	@Override
	public String toString()
	{
		return outputDirectory.getName();
	}
	
	/**
	 * Override equals() method
	 * @param obj <b>Object</b>
	 * @return <b>boolean</b> - True if the two objects are equal
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( obj == null ) {
			return false;
		}
		
		if( !(obj instanceof Instructor) ) {
			return false;
		}
		
		if( this == obj ) {
			return true;
		}
		
		Instructor copyObj = (Instructor) obj;
		
		return this.students.equals( copyObj.students ) &&
			   this.stuPairs.equals( copyObj.stuPairs ) &&
			   this.templateSpecified == copyObj.templateSpecified &&
			   this.sheetNameSpecified == copyObj.sheetNameSpecified &&
			   this.receivedSubmissions == copyObj.receivedSubmissions &&
			   this.parsedStudentSubmissions == copyObj.parsedStudentSubmissions &&
			   this.analyzedTokenSequences == copyObj.analyzedTokenSequences &&
			   this.outputDirectory.equals(copyObj.outputDirectory) &&
			   this.sheetName.equals( copyObj.sheetName ) &&
			   this.template.equals( copyObj.template );
	}
	
	/**
	 * Override clone() method
	 * @return <b>Object</b> - A deep copy of this object
	 */
	@Override
	public Object clone()
	{
		return new Instructor( this );
	}
	
} // End of Instructor Class



