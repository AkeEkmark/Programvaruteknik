package laboration2;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lektion3.JsonToMapParser;
import lektion3.UrlFetcher;

public class FootballGoalSource implements DataSource {

	@Override
	public String getName() {
		
		return "Antal mål per matchdag";
	}

	@Override
	public String getUnit() {
		
		return "Antal mål";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher urlFetcher = new UrlFetcher("http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=100");
		JsonToMapParser parser = new JsonToMapParser(urlFetcher.getContent());
		Map<String, Object> parserResult = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();
		for (Map<Object, Object> event : (List<Map<Object,Object>>) parserResult.get("events")) {
			LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
			int goals = Integer.parseInt(event.get("homeTeamScore").toString());
			goals += Integer.parseInt(event.get("visitingTeamScore").toString());
			addGoalsToDate(result, date, goals);
		}
		return result;
	}
	public void addGoalsToDate(Map<LocalDate, Double> result, LocalDate date, int goals) {
		if(! result.containsKey(date)) {
			result.put(date, (double)goals);
		}
		else {
			result.put(date, result.get(date) + (double) goals);
		}
	}
	

}
