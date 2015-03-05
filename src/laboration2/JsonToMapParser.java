package laboration2;

import java.util.Map;

import com.owlike.genson.Genson;

public class JsonToMapParser {
	private final String json;

	public JsonToMapParser(String json) {
		this.json = json;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResult() {
		Genson g = new Genson();
		return new Genson().deserialize(json, Map.class);
		
	}
}
