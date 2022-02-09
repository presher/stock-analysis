package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import fileprocessors.StockFileReader;

public class AggregatorProcessor<T extends Aggregator> {
	
	T app;
	String file;
	
	public AggregatorProcessor(T app, String file) {
		super();
		this.app = app;
		this.file = file;
	}

	@Override
	public String toString() {
		return "AggregatorProcessor [app=" + app + ", file=" + file + "]";
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
			app.add(dval);
		}
		
		double values = app.calculate()
;		return  values;
	}
}
