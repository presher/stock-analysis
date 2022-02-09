package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		//update the constructor for desired aggegator
		//current aggregator is Mean, also use Min, and Max
		//update the generics as well to match the constructor
		MeanAggregator agg = new MeanAggregator();
		AggregatorProcessor<MeanAggregator> aggsProcessor = new AggregatorProcessor<MeanAggregator>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(1);
		System.out.println(value);

	}

}
