package laboration1;

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

