package laboration2;
/**
 * 
 * @author hfk10aek
 *
 */
public class DataPair {
	private final Double x;
	private final Double y;
	public DataPair(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	public Double getX() {
		return x;
	}
	public Double getY() {
		return y;
	}
	@Override
	public String toString() {
		return "Source 1 : " +getX() +", Source 2 : " +getY(); 
	}
}
