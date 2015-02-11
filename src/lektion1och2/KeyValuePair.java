package lektion1och2;

import java.time.LocalDate;

class KeyValuePair {
	private final LocalDate key;
	private final Double value;
	public KeyValuePair(LocalDate key, double value) {
		this.key = key;
		this.value = value;
	}
	public LocalDate getKey() {
		return key;
	}
	public double getValue() {
		return value;
	}
}
