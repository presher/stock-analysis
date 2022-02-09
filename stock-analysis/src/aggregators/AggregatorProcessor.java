package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import fileprocessors.StockFileReader;

public class AggregatorProcessor<T extends Aggregator> {
	
	T aggregator;
	String file;
	
	public AggregatorProcessor(T aggregator, String file) {
		super();
		this.aggregator = aggregator;
		this.file = file;
	}

	@Override
	public String toString() {
		return "AggregatorProcessor [aggregator=" + aggregator + ", file=" + file + "]";
	}

	public double runAggregator(int i) throws IOException {	
		StockFileReader sFR = new StockFileReader(file);
		List<String> lines = sFR.readFileData();
		System.out.println("lines" + lines.get(i));
		ArrayList<String> list = new ArrayList<>();
		i--;
		System.out.println("size " + list);
		for(String line: lines) {
			String[] values = line.split(",");
			double dval = Double.parseDouble(values[i]);
			aggregator.add(dval);
		}
		
		double values = aggregator.calculate()
;		return  values;
	}
}
