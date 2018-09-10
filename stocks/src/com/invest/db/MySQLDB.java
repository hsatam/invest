/**
 * 
 */
package com.invest.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author HemantSatam
 *
 */
public class MySQLDB implements Database {

	MysqlDataSource dataSource; // MySQLDataSource Object // NOPMD by hemantsatam on 9/9/18 6:05 PM
	/**
	 * @return the dataSource
	 */
	public MysqlDataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public final void setDataSource(final MysqlDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Implements Database interface for MySQLDB database
	 */
	public MySQLDB() {
		this.setDataSource(new MysqlDataSource());
	}

	/**
	 * getDBConnection method used to get MySQLSB Connection Object
	 * @return Connection
	 * @see com.invest.db.Database#getDBConnection()
	 */
	public final Connection getDBConnection() throws SQLException {
 
		dataSource.setUrl("jdbc:mysql://localhost:3306/com.invest?useSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("P@ssword");

		return dataSource.getConnection();
	}

}
