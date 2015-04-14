package laboration2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lektion3.JsonToMapParser;
import lektion3.UrlFetcher;

public class BitCoinSource implements DataSource {

	@Override
	public String getName() {
		return "total number of bitcoins mined";
	}

	@Override
	public String getUnit() {
		return "Number of bitcoins";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher urlFetcher = new UrlFetcher("https://www.quandl.com/api/v1/datasets/BCHAIN/TOTBC.json?auth_token=DsjqZyV2mKXfLzpLGV9Y");
		JsonToMapParser parser = new JsonToMapParser(urlFetcher.getContent());
		Map<String, Object> parserResult = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();
		List<List<Object>> data = (List<List<Object>>) parserResult.get("data");
		for (List<Object> entry : data) {
			LocalDate date = LocalDate.parse(entry.get(0).toString());
			double nbrOf = (Double) entry.get(1);
			result.put(date, nbrOf);
			
		}
		return result;
	}

}
