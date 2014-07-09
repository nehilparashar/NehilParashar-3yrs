package com;
/**
 * 
 */

/**
 * @author Nehil Parashar
 * 
 * This class has some helper methods.
 * It has the methods to parse the input line (one at a time)
 * and fill the appropriate object(s). (CSVLinePresentation & CompanyDetails)
 */
public class CSVLineParser
{
	
	/**
	 * Given an input line it fills a given CSVLinePresentation object. 
	 * 
	 * @param inputLine_in
	 * @param aLineInputobj_in
	 */
	public static void updateLinePresentation(String inputLine_in, CSVLinePresentation aLineInputobj_in)
	{
		if(inputLine_in == null || inputLine_in.trim().equals(""))
			return ;
		
		if(aLineInputobj_in == null)
			return;
		
		String[] values = inputLine_in.split(",");
		
		// year, month and at least one company must be present.
		if(values.length < 3)
		{
			System.out.println("\" "+ inputLine_in + "\" is not properly formatted");
			return;
		}
		
		try
		{
			aLineInputobj_in.setYear(Integer.parseInt(values[0].trim()));
		}
		catch(NumberFormatException e)
		{
			System.out.println("\" "+ inputLine_in + "\" is not properly formatted");
			return;
		}
		
		aLineInputobj_in.setMonth(values[1].trim());
		
		aLineInputobj_in.setSharePrices(new int[values.length - 2]);
		for(int i=2; i<values.length; i++)
		{
			int[] sharePrices = aLineInputobj_in.getSharePrices(); 
			try
			{
				sharePrices[i-2] = Integer.parseInt(values[i].trim());
			}
			catch(NumberFormatException e)
			{
				System.out.println("\" "+ inputLine_in + "\" is not properly formatted");
			}
		}
	}
	
	
	
	/**
	 * Fills the company names in Company Details object 
	 * from the header of CSV file.
	 * 
	 * @param inputLine_in
	 */
	public static CompanyDetails[] fillCompanyNames(String inputLine_in)
	{
		if(inputLine_in == null || inputLine_in.trim().equals(""))
			return null;
		
		String[] values = inputLine_in.split(",");
		
		// year, month and at least one company must be present.
		if(values.length < 3)
		{
			System.out.println("\" "+ inputLine_in + "\" is not properly formatted");
			return null;		
		}
		
		CompanyDetails[] compDetailsArr = new CompanyDetails[values.length-2]; 
		
		for(int i=2; i<values.length; i++)
		{
			CompanyDetails cd = new CompanyDetails();
			cd.setCompanyName(values[i].trim());
			compDetailsArr[i-2] = cd;
		}
		
		return compDetailsArr;
	}
	
	
	
	/**
	 * Updates the company detail object if given line object has higher
	 * share price. Then it updates the line object values to Company Details object.
	 * 
	 * @param aLineInputobj_in
	 * @param cd_in
	 */
	public static void updateCompanyDetails(CSVLinePresentation aLineInputobj_in, CompanyDetails[] cd_in)
	{
		int[] sharePrices = aLineInputobj_in.getSharePrices();
		for(int i=0; i<sharePrices.length; i++)
		{
			int maxSharePrice = cd_in[i].getMaxSharePrice();
			if(sharePrices[i] > maxSharePrice)
			{
				cd_in[i].setMaxSharePrice(sharePrices[i]);
				cd_in[i].setYear(aLineInputobj_in.getYear());
				cd_in[i].setMonth(aLineInputobj_in.getMonth());
			}
		}
	}
}