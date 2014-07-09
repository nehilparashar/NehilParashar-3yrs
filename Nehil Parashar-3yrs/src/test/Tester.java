package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.CSVLineParser;
import com.CSVLinePresentation;
import com.CompanyDetails;

import junit.framework.TestCase;

/**
 * @author Nehil Parashar
 * 
 * Test class to test CSVLineParser
 */
public class Tester extends TestCase
{
	/**
	 * testcase to test if companies are added 
	 * and count is correct.
	 */
	public void test_fillCompanyNames()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the fullpath of correctly formatted csv file (test data): ");
		String filepath = in.nextLine();
		
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(new FileReader(filepath));
			String header = br.readLine();
			CompanyDetails[] cd = CSVLineParser.fillCompanyNames(header);
			assertEquals(cd.length,5);
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	
	/**
	 * testcase to test if input csv header is ill formatted, then
	 * companies are not added
	 */
	public void test_fillCompanyNames_illFormatHeader()
	{

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the fullpath of ill- formatted header csv file (test data): ");
		String filepath = in.nextLine();
		
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(new FileReader(filepath));
			String header = br.readLine();
			CompanyDetails[] cd = CSVLineParser.fillCompanyNames(header);
			assertEquals(cd,null);
		}
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	
	/**
	 * tests if max share price is calculated correctly
	 */
	public void test_checkMaxSharePrice()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the fullpath of correctly formatted csv file (test data): ");
		String filepath = in.nextLine();
		
		BufferedReader br = null;
		CompanyDetails[] compDetails = null;
		
		try
		{
			br = new BufferedReader(new FileReader(filepath));
			String header = br.readLine();
			compDetails = CSVLineParser.fillCompanyNames(header);
			assertEquals(compDetails.length,5);
			
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
		catch(FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		for(int i=0;i<compDetails.length;i++)
		{
			switch(i)
			{
				case 0: assertEquals(compDetails[i].getMaxSharePrice(),1000); break;
				case 1: assertEquals(compDetails[i].getMaxSharePrice(),986); break;
				case 2: assertEquals(compDetails[i].getMaxSharePrice(),995); break;
				case 3: assertEquals(compDetails[i].getMaxSharePrice(),999); break;
				case 4: assertEquals(compDetails[i].getMaxSharePrice(),995); break;
			}
		}
	}
}