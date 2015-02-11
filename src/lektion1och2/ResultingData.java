package lektion1och2;

import java.util.Map;

/**
 * 
 * @author hfk10aek
 *
 */
public class ResultingData {
	private DataSource source1;
	private DataSource source2;
	private Map<String, DataPair> data;
	public ResultingData(DataSource source1, DataSource source2, Map<String, DataPair> data) {
		this.source1 = source1;
		this.source2 = source2;
		this.data = data;
	}
	public String getXSourceName() {
		return source1.getName();
	}
	public String getYSourceName() {
		return source2.getName();
	}
	public String getXUnit() {
		return source1.getUnit();
	}
	public String getYUnit() {
		return source2.getUnit();
	}
	public Map<String, DataPair> getData() {
		return data;
	}
}
