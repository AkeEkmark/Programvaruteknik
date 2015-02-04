package lektion1;
/**
 * 
 */
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DataMatcherTest {
	private DataMatcher DataMatcher;
	private DataSource source1 = new DataSource() {
		
		@Override
		public String getUnit() {
			return "Grader";
		}
		
		@Override
		public String getName() {
			return "Temperatur i Gävle";
		}
		
		@Override
		public Map<Date, Double> getData() {
			Map<Date, Double> map = new HashMap<Date, Double>();
			map.put(new Date(2015, 1, 1), 9.0);
			map.put(new Date(2015, 1, 2), 7.0);
			map.put(new Date(2015, 1, 3), 1.0);
			map.put(new Date(2015, 1, 4), 3.0);
			map.put(new Date(2015, 1, 5), 5.0);
			
			return map;
		}
	};
	private DataSource source2 = new DataSource() {
		
		@Override
		public String getUnit() {
			return "Antal";
		}
		
		@Override
		public String getName() {
			
			return "Benbrott på sjukhuset";
		}
		
		@Override
		public Map<Date, Double> getData() {
			Map<Date, Double> map = new HashMap<Date, Double>();
			map.put(new Date(2015, 1, 1), 0.0);
			map.put(new Date(2015, 1, 2), 1.0);
			map.put(new Date(2015, 1, 3), 4.0);
			map.put(new Date(2015, 1, 4), 2.0);
			map.put(new Date(2015, 1, 5), 1.0);
			
			return map;
		}
		
	};
	
	@Before
	public void setUp() throws Exception {
		DataMatcher = new DataMatcher(source1, source2, 1);
	}

	@Test
	public void testDoTheJob() {
		
		fail("Not yet implemented");
	}

}
