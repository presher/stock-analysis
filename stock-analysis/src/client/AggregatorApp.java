package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		MeanAggregator agg = new MeanAggregator();
		AggregatorProcessor<MeanAggregator> aggsProcessor = new AggregatorProcessor<MeanAggregator>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(1);
		System.out.println(value);

	}

}
