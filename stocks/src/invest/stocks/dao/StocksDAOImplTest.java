/**
 * 
 */
package invest.stocks.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author HemantSatam
 *
 */
public class StocksDAOImplTest {

	StocksDAOImpl stocksDAOImplTest = new StocksDAOImpl();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#StocksDAOImpl()}.
	 */
	@Test
	public void testStocksDAOImpl() {
		StocksDAOImpl stocksDAOImpl = new StocksDAOImpl();
		assertEquals(new StocksDAOImpl().getClass(), stocksDAOImpl.getClass());
	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#findAll()}.
	 */
	@Test
	public void testFindAll() {
		Stocks stocksTest = new Stocks(1,"ISIN", "BSECODE", "NSECODE", "STOCKNAME");
		stocksDAOImplTest.delete(stocksTest);
		stocksDAOImplTest.insert(stocksTest);
		
		List<Stocks> stocks = new ArrayList<Stocks>();
		stocks = stocksDAOImplTest.findAll();
		
		for (int i=0; i < stocks.size(); i++) {
			assertEquals(stocks.get(i).getStockId(), stocksTest.getStockId());
			assertEquals(stocks.get(i).getStockName(), stocksTest.getStockName());
			assertEquals(stocks.get(i).getIsin(), stocksTest.getIsin());
			assertEquals(stocks.get(i).getBseCode(), stocksTest.getBseCode());
			assertEquals(stocks.get(i).getNseCode(), stocksTest.getNseCode());		
		}
	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#findByPK(int)}.
	 */
	@Test
	public void testFindByPK() {
		Stocks stocks = new Stocks(1,"ISIN", "BSECODE", "NSECODE", "STOCKNAME");
		stocksDAOImplTest.delete(stocks);
		stocksDAOImplTest.insert(stocks);

		Stocks findByPKStock = stocksDAOImplTest.findByPK(1);
		assertEquals(findByPKStock.getStockId(), stocks.getStockId());
		assertEquals(findByPKStock.getStockName(), stocks.getStockName());
		assertEquals(findByPKStock.getIsin(), stocks.getIsin());
		assertEquals(findByPKStock.getBseCode(), stocks.getBseCode());
		assertEquals(findByPKStock.getNseCode(), stocks.getNseCode());

	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#findbystockname(java.lang.String)}.
	 */
	@Test
	public void testFindbystockname() {
		Stocks stocks = new Stocks(1,"ISIN", "BSECODE", "NSECODE", "STOCKNAME");
		List<Stocks> findByStockName = stocksDAOImplTest.findbystockname("STOCKNAME");
		for (int i=0;i<findByStockName.size();i++) {
			assertEquals(findByStockName.get(i).getStockId(), stocks.getStockId());
			assertEquals(findByStockName.get(i).getStockName(), stocks.getStockName());
			assertEquals(findByStockName.get(i).getIsin(), stocks.getIsin());
			assertEquals(findByStockName.get(i).getBseCode(), stocks.getBseCode());
			assertEquals(findByStockName.get(i).getNseCode(), stocks.getNseCode());			
		}
	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#insert(invest.stocks.dao.Stocks)}.
	 */
	@Test
	public void testInsert() {
		Stocks stocks = new Stocks(1,"ISIN", "BSECODE", "NSECODE", "STOCKNAME");
		stocksDAOImplTest.insert(stocks);
		Stocks insertStock = stocksDAOImplTest.findByPK(1);
		assertEquals(insertStock.getStockId(), stocks.getStockId());
		assertEquals(insertStock.getStockName(), stocks.getStockName());
		assertEquals(insertStock.getIsin(), stocks.getIsin());
		assertEquals(insertStock.getBseCode(), stocks.getBseCode());
		assertEquals(insertStock.getNseCode(), stocks.getNseCode());
	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#update(invest.stocks.dao.Stocks)}.
	 */
	@Test
	public void testUpdate() {
		Stocks stocks = new Stocks(1,"ISIN-U", "BSECODE-U", "NSECODE-U", "STOCKNAME-U");
		stocksDAOImplTest.update(stocks);
		Stocks updateStock = stocksDAOImplTest.findByPK(1);
		assertEquals(updateStock.getStockId(), stocks.getStockId());
		assertEquals(updateStock.getStockName(), stocks.getStockName());
		assertEquals(updateStock.getIsin(), stocks.getIsin());
		assertEquals(updateStock.getBseCode(), stocks.getBseCode());
		assertEquals(updateStock.getNseCode(), stocks.getNseCode());

	}

	/**
	 * Test method for {@link invest.stocks.dao.StocksDAOImpl#delete(invest.stocks.dao.Stocks)}.
	 */
	@Test
	public void testDelete() {
		Stocks stocks = new Stocks(1,"ISIN", "BSECODE", "NSECODE", "STOCKNAME");
		stocksDAOImplTest.delete(stocks);
		Stocks deleteStocks = stocksDAOImplTest.findByPK(1);
		assertNull(deleteStocks);
	}

}
