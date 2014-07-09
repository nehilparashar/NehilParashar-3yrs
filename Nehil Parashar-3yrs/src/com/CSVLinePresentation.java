package com;
/**
 * 
 */

/**
 * @author Nehil Parashar
 * 
 * This class is object representation of
 * a CSV file line (except header)
 * 
 * When CSVLineParser class parses the line using 'FillLineInput'
 * an object of this class is filled.
 *
 */
public class CSVLinePresentation
{	
	private int year;
	private String month;
	private int[] sharePrices;
	
	/**
	 * @return the sharePrices
	 */
	public int[] getSharePrices() {
		return sharePrices;
	}


	/**
	 * @param sharePrices the sharePrices to set
	 */
	public void setSharePrices(int[] sharePrices) {
		this.sharePrices = sharePrices;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}


	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}


	/**
	 * clears the instance fields
	 */
	public void clear()
	{
		sharePrices = null;
		year = 0;
		month = null;
	}
	
	
	/**
	 * Checks if this object has default values
	 * this method helps in running test cases
	 * 
	 * @return
	 */
	public boolean hasDefaultValues()
	{
		return this.sharePrices == null && this.year == 0 && this.month == null;
	}
}
