package laboration2;
/**
 * 
 */
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DataMatcherTest {
	private DataMatcher dataMatcher;
	private ResultingData result;
	private DataSource source1;
	private DataSource source2;
	
	@Before
	public void setUp() throws Exception {
		source1 = new DataSource() {
			
			@Override
			public String getUnit() {
				return "Grader";
			}
			
			@Override
			public String getName() {
				return "Temperatur i Gävle";
			}
			
			@Override
			public Map<LocalDate, Double> getData() {
				Map<LocalDate, Double> map = new HashMap<LocalDate, Double>();
				map.put(LocalDate.parse("2015-01-01"), 9.0);
				map.put(LocalDate.parse("2015-01-02"), 7.0);
				map.put(LocalDate.parse("2015-01-03"), -1.0);
				map.put(LocalDate.parse("2015-01-04"), -3.0);
				map.put(LocalDate.parse("2015-01-06"), -5.0);
				
				return map;
			}
		};
		source2 = new DataSource() {
			
			@Override
			public String getUnit() {
				return "Antal";
			}
			
			@Override
			public String getName() {	
				return "Benbrott på sjukhuset";
			}
			
			@Override
			public Map<LocalDate, Double> getData() {
				Map<LocalDate, Double> map = new HashMap<LocalDate, Double>();
				map.put(LocalDate.parse("2015-01-01"), 0.0);
				map.put(LocalDate.parse("2015-01-02"), 1.0);
				map.put(LocalDate.parse("2015-01-03"), 4.0);
				map.put(LocalDate.parse("2015-01-04"), 2.0);
				map.put(LocalDate.parse("2015-01-05"), 1.0);
				
				return map;
			}
			
		};
		
		dataMatcher = new DataMatcher(source1, source2, Resolution.WEEK);
		result = dataMatcher.doTheJob();
	}

	@Test
	public void testDoTheJob() {
		
		assertEquals(2, result.getData().size());
		assertEquals("Temperatur i Gävle", result.getXSourceName());
		assertEquals("Grader", result.getXUnit());
		assertEquals("Benbrott på sjukhuset", result.getYSourceName());
		assertEquals("Antal", result.getYUnit());
	}

}
