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
	
	/**
	 * Constructor that accepts an array of String
	 * @param args String[] command-line parameter
	 */
	public ArgumentParser( String[] args )
	{
		
	}
	
	/**
	 * Checks the command-line parameter and see if the usage is proper.
	 * @return True boolean true if the arguments are proper.
	 */
	public boolean isProperArgs()
	{
		return false;
	}
	
	/**
	 * Checks the command-line parameter and see if user asked for help
	 * by including the -help option.
	 * @return True boolean true if user used the -help option
	 */
	public boolean argsContainHelp()
	{
		return false;
	}
	
	/**
	 * Checks the command-line parameter and see if user specified -raw
	 * @return True boolean True if user used the -raw option
	 */
	public boolean argsContainSheetName()
	{
		return false;
	}
	
	/**
	 * Return -template arg as String
	 * @return tempArg String The string after -template
	 */
	public String getTemplateArg()
	{
		return null;
	}
	
	/**
	 * Return -raw arg as String
	 * @return rawArg String The string after -raw
	 */
	public String getSheetNameArg()
	{
		return null;
	}
	
	/**
	 * Checks the command-line parameter and see if user specified -template
	 * @return True boolean true if user used the -template option
	 */
	public boolean argsContainTemplate()
	{
		return false;
	}
	
} // End of ArgumentParser



