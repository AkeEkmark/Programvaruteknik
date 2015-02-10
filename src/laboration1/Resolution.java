package laboration1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

enum Resolution {
	YEAR {
		
		@Override
		public Map<LocalDate, Double> compactData(Map<LocalDate, Double> data) {
			Map<LocalDate, Double> compacted = new HashMap<LocalDate, Double>();
			int year;
			
			Double value;
			Double values = 0.0;
			int nbrOfDates = 0;
			for (LocalDate date : data.keySet()) {
				year = date.getYear();
				
				if (!compacted.containsKey(LocalDate.of(year, 1, 1))) {
					value = data.get(date);
					values += value;
					nbrOfDates++;
					for (LocalDate date2 : data.keySet()) {
						if (date2.getYear() == year) {
							values += data.get(date2);
							nbrOfDates++;	
						}
					}
					value = values/nbrOfDates;
					LocalDate firstOfTheMonth = LocalDate.of(year, 1, 1);
					compacted.put(firstOfTheMonth, value);
					values = 0.0;
					nbrOfDates = 0;
				}
			}			
			return compacted;
			
		}
	}, QUARTER {

		@Override
		public Map<LocalDate, Double> compactData(Map<LocalDate, Double> data) {
			Map<LocalDate, Double> compacted = new HashMap<LocalDate, Double>();
			int year;
			int month;
			Double value;
			Double values = 0.0;
			int nbrOfDates = 0;
			for (LocalDate date : data.keySet()) {
				year = date.getYear(); 
				month = quarter(date.getMonthValue());
					
				if (!compacted.containsKey(LocalDate.of(year, month, 1))) {
					value = data.get(date);
					values += value;
					nbrOfDates++;
					for (LocalDate date2 : data.keySet()) {
						if (date2.getYear() == year && quarter(date2.getMonthValue()) == month) {
							values += data.get(date2);
							nbrOfDates++;	
						}
					}
					value = values/nbrOfDates;
					LocalDate firstOfTheMonth = LocalDate.of(year, month, 1);
					compacted.put(firstOfTheMonth, value);
					values = 0.0;
					nbrOfDates = 0;
				}
			}			
			return compacted;
		}

		private int quarter(int month) {
			if (month < 4) {
				return 1;
			}
			else if (month < 7){
				return 4;
			}
			else if (month < 10) {
				return 7;
			}	
			return 4;
		}
	}, MONTH {

		@Override
		public Map<LocalDate, Double> compactData(Map<LocalDate, Double> data) {
			Map<LocalDate, Double> compacted = new HashMap<LocalDate, Double>();
			int year;
			int month;
			Double value;
			Double values = 0.0;
			int nbrOfDates = 0;
			for (LocalDate date : data.keySet()) {
				year = date.getYear();
				month = date.getMonthValue();
				if (!compacted.containsKey(LocalDate.of(year, month, 1))) {
					value = data.get(date);
					values += value;
					nbrOfDates++;
					for (LocalDate date2 : data.keySet()) {
						if (date2.getYear() == year && date2.getMonthValue() == month) {
							values += data.get(date2);
							nbrOfDates++;	
						}
					}
					value = values/nbrOfDates;
					LocalDate firstOfTheMonth = LocalDate.of(year, month, 1);
					compacted.put(firstOfTheMonth, value);
					values = 0.0;
					nbrOfDates = 0;
				}
			}			
			return compacted;
		}
	}
	, DAY {

		@Override
		public Map<LocalDate, Double> compactData(Map<LocalDate, Double> data) {
			
			return data;
		}
	};
	
	public abstract Map<LocalDate, Double> compactData(Map<LocalDate, Double> data) ;
}
