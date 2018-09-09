package invest.stocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import invest.db.MySQLDB;
import invest.exception.DatabaseException;

/**
 * StocksDAOImpl class provides implementation for StocksDAO
 * 
 */

public class StocksDAOImpl implements StocksDAO {

	/**
	 * LOGGER is the static variable to log all events
	 * 
	 */
	private static Logger LOGGER = null; // NOPMD by hemantsatam on 9/9/18 8:38 PM
	/**
	 * 
	 */
	public StocksDAOImpl() {
		super();
		LOGGER = Logger.getLogger(StocksDAOImpl.class.getName());
	}

	/**
	 * findAll method provides all a List of All Stocks
	 * 
	 * @see invest.stocks.dao.StocksDAO#findAll()
	 */
	@Override
	public List<Stocks> findAll() throws DatabaseException {
		final String sql = "select * from stockmaster";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			final List<Stocks> stocks = new ArrayList<Stocks>();

			ResultSet rs = prepredStatement.executeQuery(); // NOPMD by hemantsatam on 9/9/18 8:15 PM
			if (rs.next()) {
				stocks.add(new Stocks (
					rs.getInt("STOCKID"),
					rs.getString("ISIN"),
					rs.getString("BSECODE"),
					rs.getString("NSECODE"),
					rs.getString("STOCKNAME")
				));
			}
			rs.close();
			prepredStatement.close();
			
			return stocks;
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {LOGGER.severe(e.getMessage());}
			}
		}
	}

	/**
	 * findByPK enables searching Stocks by stockId
	 * 
	 * @return Stocks
	 * 
	 * @see invest.stocks.dao.StocksDAO#findByPK(int)
	 */
	@Override
	public Stocks findByPK(final int stockId) throws DatabaseException {
		final String sql = "select * from stockmaster where StockId = ?";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			prepredStatement.setInt(1, stockId);
			Stocks stocks = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
			ResultSet rs = prepredStatement.executeQuery(); // NOPMD by hemantsatam on 9/9/18 8:15 PM
			if (rs.next()) {
				stocks = new Stocks (
					rs.getInt("STOCKID"),
					rs.getString("ISIN"),
					rs.getString("BSECODE"),
					rs.getString("NSECODE"),
					rs.getString("STOCKNAME")
				);
			}
			rs.close();
			prepredStatement.close();
			
			return stocks;
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {LOGGER.severe(e.getMessage());}
			}
		}
	}

	/**
	 * findbystockname method provides List of Stocks matching stock name provided
	 * 
	 * @return List<Stocks>
	 * 
	 */
	@Override
	public List<Stocks> findbystockname(final String stockName) throws DatabaseException {
		final String sql = "select * from stockmaster where StockName = ?";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			prepredStatement.setString(1, stockName);
			final List<Stocks> stocks = new ArrayList<Stocks>();

			ResultSet rs = prepredStatement.executeQuery(); // NOPMD by hemantsatam on 9/9/18 8:15 PM
			if (rs.next()) {
				stocks.add(new Stocks (
					rs.getInt("STOCKID"),
					rs.getString("ISIN"),
					rs.getString("BSECODE"),
					rs.getString("NSECODE"),
					rs.getString("STOCKNAME")
				));
			}
			rs.close();
			prepredStatement.close();
			
			return stocks;
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {LOGGER.severe(e.getMessage());}
			}
		}
	}

	/**
	 * insert method enables insertion of stocks into the stocks database
	 * 
	 * @see invest.stocks.dao.StocksDAO#insert(invest.stocks.dao.Stocks)
	 */
	@Override
	public void insert(final Stocks stocks) throws DatabaseException {
		final String sql = "insert into stockmaster (stockid, isin, bsecode, nsecode, stockname) values (?, ?, ?, ?, ?)";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			prepredStatement.setInt(1, stocks.getStockId());
			prepredStatement.setString(2, stocks.getIsin());
			prepredStatement.setString(3, stocks.getBseCode());
			prepredStatement.setString(4, stocks.getNseCode());
			prepredStatement.setString(5, stocks.getStockName());
			
			prepredStatement.execute(); // NOPMD by hemantsatam on 9/9/18 8:15 PM

			prepredStatement.close();
			
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { LOGGER.severe(e.getMessage());}
			}
		}
	}

	/**
	 * update method enables update of Stocks table based on stockId
	 * 
	 * @see invest.stocks.dao.StocksDAO#update(invest.stocks.dao.Stocks)
	 */
	@Override
	public void update(final Stocks stocks) throws DatabaseException {
		final String sql = "update stockmaster set isin=?, bsecode=?, nsecode=?, stockname=? where stockid=?";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			prepredStatement.setString(1, stocks.getIsin());
			prepredStatement.setString(2, stocks.getBseCode());
			prepredStatement.setString(3, stocks.getNseCode());
			prepredStatement.setString(4, stocks.getStockName());
			prepredStatement.setInt(5, stocks.getStockId());
			
			prepredStatement.execute(); // NOPMD by hemantsatam on 9/9/18 8:15 PM

			prepredStatement.close();
			
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {LOGGER.severe(e.getMessage());}
			}
		}
	}

	/**
	 * delete method enables deletion of stocks based on stockId
	 * 
	 * @see invest.stocks.dao.StocksDAO#delete(invest.stocks.dao.Stocks)
	 */
	@Override
	public void delete(final Stocks stocks) throws DatabaseException {
		final String sql = "delete from stockmaster where stockid=?";
		
		Connection conn = null; // NOPMD by hemantsatam on 9/9/18 8:27 PM
		try {
			final MySQLDB mySqlDB = new MySQLDB();
			conn = mySqlDB.getDBConnection();
			final PreparedStatement prepredStatement = conn.prepareStatement(sql);
			prepredStatement.setInt(1, stocks.getStockId());
			
			prepredStatement.execute(); // NOPMD by hemantsatam on 9/9/18 8:15 PM

			prepredStatement.close();
			
		} catch (SQLException e) {
			LOGGER.severe(e.getMessage());
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {LOGGER.severe(e.getMessage());}
			}
		}
	}

}
