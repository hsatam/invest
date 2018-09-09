package invest.stocks.dao;

import java.util.List;

import invest.exception.DatabaseException;

/**
 * StocksDAO interface provides CRUD methods for Stocks database object
 */
public interface StocksDAO {

	/**
	 * findAll method lists all Stocks in database 
	 */
	public List<Stocks> findAll() throws DatabaseException; // NOPMD by hemantsatam on 9/9/18 8:56 PM
	
	/**
	 * findByPK methods retrieves Stocks matching stockId
	 * @param stockId
	 * @return Stocks
	 * @throws DatabaseException
	 */
	public Stocks findByPK(int stockId) throws DatabaseException;     // NOPMD by hemantsatam on 9/9/18 8:56 PM

	/**
	 * findbystockname returns Stock object matching stockName
	 * @param stockName
	 * @return Stocks
	 * @throws DatabaseException
	 */
	public List<Stocks> findbystockname(String stockName) throws DatabaseException; // NOPMD by hemantsatam on 9/9/18 8:56 PM
	
	/**
	 * insert method enbles insertion of stock details in Stock database object
	 * @param stocks
	 * @throws DatabaseException
	 */
	public void insert(Stocks stocks) throws DatabaseException; // NOPMD by hemantsatam on 9/9/18 8:56 PM
	
	/**
	 * update method enbles updation of stock details in Stock database object
	 * @param stocks
	 * @throws DatabaseException
	 */
	public void update(Stocks stocks) throws DatabaseException; // NOPMD by hemantsatam on 9/9/18 8:56 PM
	
	/**
	 * delete method enbles deletion of stock details in Stock database object
	 * @param stocks
	 * @throws DatabaseException
	 */	
	public void delete(Stocks stocks) throws DatabaseException; // NOPMD by hemantsatam on 9/9/18 8:56 PM
	
}
