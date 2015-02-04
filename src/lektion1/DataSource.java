package lektion1;

import java.time.LocalDate;
import java.util.Map;
/**
 * 
 * @author hfk10aek
 *
 */
public interface DataSource {
	
	String getName();
	String getUnit();
	Map<LocalDate, Double> getData();
	
}

//class KeyValuePair {
//	private final Date key;
//	private final Double value;
//	public KeyValuePair(Date key, double value) {
//		this.key = key;
//		this.value = value;
//	}
//	public Date getKey() {
//		return key;
//	}
//	public double getValue() {
//		return value;
//	}
//}