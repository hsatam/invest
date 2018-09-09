/**
 * 
 */
package invest.stocks.dao;

/**
 * @author HemantSatam
 *
 * Stocks class used to store data from stockmaster
 * Includes stockId, isin, bseCode, nseCode, stockName
 * 
 */
public class Stocks {

	/**
	 * @param stockId
	 * @param isin
	 * @param bseCode
	 * @param nseCode
	 * @param stockName
	 */
	public Stocks(final int stockId, final String isin, final String bseCode, final String nseCode, final String stockName) {
		super();
		this.stockId = stockId;
		this.isin = isin;
		this.bseCode = bseCode;
		this.nseCode = nseCode;
		this.stockName = stockName;
	}

	private int stockId; // NOPMD by hemantsatam on 9/9/18 3:08 PM
	private String isin; // NOPMD by hemantsatam on 9/9/18 3:08 PM
	private String bseCode; // NOPMD by hemantsatam on 9/9/18 3:08 PM
	private String nseCode; // NOPMD by hemantsatam on 9/9/18 3:08 PM
	private String stockName; // NOPMD by hemantsatam on 9/9/18 3:08 PM
	
	/**
	 * @return the Stock Id
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param Stock Id
	 */
	final public void setStockId(final int stockId) {
		this.stockId = stockId;
	}

	/**
	 * @return the ISIN
	 */
	public String getIsin() {
		return isin;
	}

	/**
	 * @param ISIN
	 */
	final public void setIsin(final String isin) {
		this.isin = isin;
	}

	/**
	 * @return the BSE Code
	 */
	public String getBseCode() {
		return bseCode;
	}

	/**
	 * @param BSE Code
	 */
	final public void setBseCode(final String bseCode) {
		this.bseCode = bseCode;
	}

	/**
	 * @return the NSE Code
	 */
	public String getNseCode() {
		return nseCode;
	}

	/**
	 * @param NSE Code
	 */
	final public void setNseCode(final String nseCode) {
		this.nseCode = nseCode;
	}

	/**
	 * @return the Stock Name
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @param Stock Name
	 */
	final public void setStockName(final String stockName) {
		this.stockName = stockName;
	}

}
