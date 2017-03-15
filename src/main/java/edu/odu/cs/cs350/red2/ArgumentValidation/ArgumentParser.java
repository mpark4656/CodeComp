package edu.odu.cs.cs350.red2.ArgumentValidation;

/**
 * This helper class is responsible for checking the command-line
 * parameter provided by user and ensure that it's proper - All of 
 * these methods could have resided in CodeComp.java as static methods, 
 * but I don't want CodeComp.java to be cluttered.
 * @author mpark
 */
public class ArgumentParser
{
	private String[] args;
	
	public ArgumentParser( String[] args )
	{
		
	}
	
	/**
	 * Checks the command-line parameter and see if the usage is proper.
	 * 
	 * @param args
	 * @return True boolean true if the arguments are proper.
	 */
	public boolean properArgs( String[] args )
	{
		return false;
	}
	
	/**
	 * Checks the command-line parameter and see if user asked for help
	 * by including the -help option.
	 * @param args
	 * @return True boolean true if user used the -help option
	 */
	public boolean argsContainHelp( String[] args )
	{
		return false;
	}
	
	/**
	 * Checks the command-line parameter and see if user specified -raw
	 * @param args
	 * @return True boolean True if user used the -raw option
	 */
	public boolean argsContainSheetName( String[] args )
	{
		return false;
	}
	
	/**
	 * Return -template arg as String
	 * @param args
	 * @return tempArg String The string after -template
	 */
	public String getTemplateArg( String[] args )
	{
		return null;
	}
	
	/**
	 * Return -raw arg as String
	 * @param args
	 * @return rawArg String The string after -raw
	 */
	public String getSheetNameArg( String[] args )
	{
		return null;
	}
	
	/**
	 * Checks the command-line parameter and see if user specified -template
	 * @param args
	 * @return True boolean true if user used the -template option
	 */
	public boolean argsContainTemplate( String[] args )
	{
		return false;
	}
	
} // End of ArgumentParser



