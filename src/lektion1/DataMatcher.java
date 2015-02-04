package lektion1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author hfk10aek
 *
 */
public class DataMatcher {
	private final DataSource source1;
	private final DataSource source2;
	private final int resolution;
	
	public DataMatcher(DataSource source1, DataSource source2, int resolution) {
		this.source1 = source1;
		this.source2 = source2;
		this.resolution = resolution;
	}
	public ResultingData doTheJob() {
		Map<String, DataPair> resultMap = new HashMap<String, DataPair>();
		Map<Date, Double> map1 = source1.getData();
		Map<Date, Double> map2 = source2.getData();
		return null;
	}
}
