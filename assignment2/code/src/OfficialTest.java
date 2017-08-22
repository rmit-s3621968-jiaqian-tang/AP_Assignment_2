package UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ap.ozlympic.model.Athlete;
import com.ap.ozlympic.model.Official;
import com.ap.ozlympic.model.Sprinter;


public class OfficialTest {

	
	List<Athlete> resultList; //= new ArrayList<>();
	List<Integer> scoreList;//= new ArrayList<>();
	
	ArrayList<Athlete> sprinterList = new ArrayList<>();
	Official referee;
	int Max = 10;
	

	@Before
	public void setUp() throws Exception {
		referee= new Official("oz4232", "Official", "Tracy", 35, "WA");
		Athlete sprinter1= new Sprinter("oz4232", "Sprinter", "Liam", 35, "WA");
		Athlete sprinter2= new Sprinter("oz1234", "Sprinter", "Kelly", 35, "WA");
		Athlete sprinter3= new Sprinter("oz5678", "Sprinter", "Tommy", 35, "WA");
		sprinterList.add(sprinter1);
		sprinterList.add(sprinter2);
		sprinterList.add(sprinter3);
		
	}

	
	
	
	@Test
	public void testRank() {
		referee.initNewGame();
		
		for(Athlete athlete : sprinterList){
			int result = Max--;
			referee.rank(athlete, result);
		}
		
		resultList = referee.getResult();
		
		
		assertEquals(3, resultList.size());
		assertEquals("Tommy", resultList.get(0).getName());
		
	}
	
	
	
	

}
