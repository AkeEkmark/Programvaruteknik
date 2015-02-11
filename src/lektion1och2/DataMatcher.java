package lektion1och2;

import java.time.LocalDate;
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
	private static final int DAY = 1;
	private static final int WEEK = 2;
	private static final int MONTH = 3;
	private static final int YEAR = 4;
	DataPair pair;
	String s;
	ResultingData resultingData;
	
	public DataMatcher(DataSource source1, DataSource source2, int resolution) {
		this.source1 = source1;
		this.source2 = source2;
		this.resolution = resolution;
	}
	public ResultingData doTheJob() {
		
		Map<String, DataPair> resultMap = new HashMap<String, DataPair>();
		Map<LocalDate, Double> map1 = source1.getData();
		Map<LocalDate, Double> map2 = source2.getData();
		for (LocalDate date : map1.keySet()) {
			if (map2.containsKey(date)) {
				pair = new DataPair(map1.get(date), map2.get(date));
				s = date.toString();
				resultMap.put(s, pair);
			}
		}
		resultingData = new ResultingData(source1, source2, resultMap);
		
		return resultingData;
	}
}
