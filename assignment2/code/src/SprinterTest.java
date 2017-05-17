package UnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ap.ozlympic.model.Athlete;
import com.ap.ozlympic.model.Sprinter;
import com.ap.ozlympic.model.Swimmer;

public class SprinterTest {

	int second;
	boolean flag;
	Athlete athlete;
	

	@Before
	public void setUp() throws Exception {
		athlete = new Sprinter("oz4232", "Sprinter", "Liam", 35, "WA");
		
	}

	

	@Test
	public void testCompete() {
		second = athlete.compete("Running");
		if(second <=20 && second >=10)
			flag =true;
		else
			flag = false;
	
		assertTrue(flag);
		
	}
	
	

}
