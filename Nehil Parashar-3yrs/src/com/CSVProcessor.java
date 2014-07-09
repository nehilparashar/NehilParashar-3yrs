package com;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nehil Parashar
 * 
 * This class has main method and is starting point of project.
 */
class CSVProcessor
{
	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedReader br = null;
		CompanyDetails[] compDetails = null;
		try
		{
			br = new BufferedReader(new FileReader("..//..//csvinput//test_shares_data.csv"));
			
			String header = br.readLine();
			if(header != null)
			{
				compDetails = CSVLineParser.fillCompanyNames(header);
				if(compDetails == null)
				{
					System.out.println("Header is missing");
					return;
				}
				
				CSVLinePresentation aCSVLinePresObj = new CSVLinePresentation();
				
				String line = null;
				while((line = br.readLine()) != null)
				{
					if(!line.trim().equals(""))
					{
						aCSVLinePresObj.clear();
						CSVLineParser.updateLinePresentation(line, aCSVLinePresObj);
						CSVLineParser.updateCompanyDetails(aCSVLinePresObj, compDetails);
					}
				}
			}
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();		
		}
		finally
		{
			if(br!=null)
			{
				try
				{
					br.close();
				}
				catch (IOException ioe)
				{
					System.out.println("Buffered reader can't be closed.");
				}
			}
		}
		
		// the company details object has the max share price and 
		// corresponding details at any time
		// just print to show output. 
		if(compDetails != null)
		{
			for(int i=0;i<compDetails.length;i++)
			{
				CompanyDetails comp = compDetails[i];
				System.out.println(comp.getCompanyName() + " " + 
								   comp.getYear() + " " + 
								   comp.getMonth() + " " + 
								   comp.getMaxSharePrice());
			}
		}
	}
}