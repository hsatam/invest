/**
 * 
 */
package invest.stocks.dao;

/**
 * @author HemantSatam
 *
 */
public class StocksDAOFactory { // NOPMD by hemantsatam on 9/9/18 8:13 PM

	/*
	 * Static Create method that will provide an instance of StocksDAOImpl
	 * 
	 * @return StocksDAOImpl
	 */
	public static StocksDAO create() { // NOPMD by hemantsatam on 9/9/18 8:13 PM
		return new StocksDAOImpl();
	}
}
