package laboration2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;



public class UrlFetcher {
	private final URL url;
	
	public UrlFetcher (String urlString) {
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	public String getContent() {
		String result = "", temp = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while ((temp = br.readLine()) != null) 
	            result += temp;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	// Test
	public static void main(String[] args) {
		UrlFetcher url = new UrlFetcher("http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=2");
		String result = url.getContent();
		System.out.println(result);
		JsonToMapParser parser = new JsonToMapParser(result);
		Map<String, Object>  mapResult = parser.getResult();
		System.out.println(mapResult.keySet());
		System.out.println(mapResult.get("credit"));
	}
}

