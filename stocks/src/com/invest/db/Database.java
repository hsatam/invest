/**
 * 
 */
package com.invest.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author HemantSatam
 *
 */
public interface Database {

	/**
     * Database specific interface to implement for a connection object
	 * @return Connection
	 * @throws SQLException
	 */
	Connection getDBConnection() throws SQLException;
	
}
