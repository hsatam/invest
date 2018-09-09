/**
 * 
 */
package invest.db;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author HemantSatam
 *
 */
public class MySQLDBTest { // NOPMD by hemantsatam on 9/9/18 6:17 PM

	/**
	 * Test method for {@link invest.db.MySQLDB#getDBConnection()}.
	 */
	@Test
	public void testGetDBConnection() throws Exception {
		final MySQLDB mySQLDB = new MySQLDB();
		assertNotNull("MySQLDB Connection not secured...",mySQLDB.getDBConnection());
	}

}
