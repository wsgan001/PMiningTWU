package idb.PMiningTWU;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MiningTWUMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
	private Text item = new Text();

	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
		String[] part = value.toString().split(":");
		String transaction = part[1];
		LongWritable utility = new LongWritable(Long.parseLong(part[0]));
	}
}
