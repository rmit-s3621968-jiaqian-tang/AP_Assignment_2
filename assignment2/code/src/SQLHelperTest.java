package UnitTest;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ap.ozlympic.model.SQLHelper;


public class SQLHelperTest {

	
	ResultSet resultset;
	String sql;
	private SQLHelper server;
	

	@Before
	public void setUp() throws Exception {
		server = new SQLHelper();
		sql = null;
		resultset = null;
	    
	}


	@Test
	public void testQuery() {
		String name1 = null;
		String name2 = "Tracy";
		sql = "select name from participants where name like 'Tracy'; ";
		resultset= server.query(sql);
		
		try {
			while(resultset.next())
			name1 = resultset.getString("Name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
			assertEquals(name1, name2);
		
	}
	
	@Test
	public void testQuery2(){
		sql = "select * from participants;";
		resultset= server.query(sql);
		assertNotNull(resultset);
	      
	}
	

}
