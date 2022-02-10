package aggregators;

import java.io.IOException;
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

	public double runAggregator(int colIndex) throws IOException {	
		StockFileReader sFR = new StockFileReader(file);
		List<String> lines = sFR.readFileData();
		colIndex--;
		for(String line: lines) {
			String[] values = line.split(",");
			double dval = Double.parseDouble(values[colIndex]);
			aggregator.add(dval);
		}
		
		double values = aggregator.calculate();
		return values;
	}
}
