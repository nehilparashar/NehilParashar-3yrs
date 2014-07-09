package com;
/**
 * 
 */

/**
 * @author Nehil Parashar
 * 
 * This class holds the company name, 
 * max share price, its year and month 
 * at any given time.
 */
public class CompanyDetails
{
	private String companyName;
	private int maxSharePrice;
	private int year;
	private String month;
	
	/**
	 * 
	 * @return company name
 	 */
	public String getCompanyName() 
	{
		return companyName;
	}
	
	/**
	 * sets the company name
	 * @param companyName
	 */
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	
	/**
	 * 
	 * @return the max share price
	 */
	public int getMaxSharePrice() 
	{
		return maxSharePrice;
	}
	
	/**
	 * sets the max share price
	 * @param maxSharePrice
	 */
	public void setMaxSharePrice(int maxSharePrice) 
	{
		this.maxSharePrice = maxSharePrice;
	}
	
	/**
	 * 
	 * @return the year
	 */
	public int getYear() 
	{
		return year;
	}
	
	/**
	 * sets the year
	 * @param year
	 */
	public void setYear(int year) 
	{
		this.year = year;
	}
	
	/**
	 * 
	 * @return the month
	 */
	public String getMonth() 
	{
		return month;
	}
	
	/**
	 * sets the month
	 * @param month
	 */
	public void setMonth(String month) 
	{
		this.month = month;
	}
}