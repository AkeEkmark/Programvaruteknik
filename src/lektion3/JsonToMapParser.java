package lektion3;

import java.util.Map;

import com.owlike.genson.Genson;

public class JsonToMapParser {
	private final String json;

	public JsonToMapParser(String json) {
		this.json = json;
	}
	
	public Map<String, Object> getResult() {
		return new Genson().deserialize(json, Map.class);
	}
}
