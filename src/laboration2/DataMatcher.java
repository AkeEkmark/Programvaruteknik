package laboration2;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author hfk10aek
 *
 */
public class DataMatcher {
	private final DataSource source1;
	private final DataSource source2;
	private final Resolution resolution;
	private DataPair pair;
	private String s;
	private ResultingData resultingData;
	
	public DataMatcher(DataSource source1, DataSource source2, Resolution resolution) {
		this.source1 = source1;
		this.source2 = source2;
		this.resolution = resolution;
		
	}
	public ResultingData doTheJob() {
		
		Map<String, DataPair> resultMap = new TreeMap<String, DataPair>();
		Map<LocalDate, Double> map1 = compactDatasource(resolution, source1.getData());
		Map<LocalDate, Double> map2 = compactDatasource(resolution, source2.getData());
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
	private Map<LocalDate, Double> compactDatasource(Resolution resolution2,
			Map<LocalDate, Double> data) {
		data = resolution2.compactData(data);
		
		return data;
	}
}
