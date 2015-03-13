package laboration2;



import org.junit.Before;
import org.junit.Test;

public class DataMatcherTestRealData {
	private DataMatcher dataMatcher;
	private ResultingData result;
	private DataSource source1;
	private DataSource source2;
	@Before
	public void setUp() throws Exception {
		source1 = new FootballGoalSource();
		source2 = new SineWaveSource();
		dataMatcher = new DataMatcher(source1, source2, Resolution.WEEK);
		result = dataMatcher.doTheJob();
	}

	@Test
	public void test() {
		System.out.println(source1.getData());
		System.out.println(source2.getData());
		System.out.println(result.toString());
	}

}
