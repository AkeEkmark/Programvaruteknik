package laboration1;

import java.time.LocalDate;
import java.util.Map;

enum Resolution {
	YEAR {
		@Override
		public Map<LocalDate, Double> compactData() {
			// TODO Auto-generated method stub
			return null;
		}
	}, QUARTER {
		@Override
		public Map<LocalDate, Double> compactData() {
			// TODO Auto-generated method stub
			return null;
		}
	}, MONTH {
		@Override
		public Map<LocalDate, Double> compactData() {
			// TODO Auto-generated method stub
			return null;
		}
	}, DAY {
		@Override
		public Map<LocalDate, Double> compactData() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	public abstract Map<LocalDate, Double> compactData() ;
}
