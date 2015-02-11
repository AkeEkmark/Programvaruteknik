package lektion3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;



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
		String result = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while ((result = br.readLine()) != null) 
	            result += result;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
}
