package idb.PMiningTWU;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class PMiningTWU {

	
	
	public PMiningTWU(){
		
	}
	
	public void startPMiningTWU(){
		
	}
	  

	public void runMiningTWU(String inFilePath, String outFilePath) throws Exception {
	    JobConf conf = new JobConf(UtilityCount.class);
	    conf.setJobName("MiningTWU");
	
	    conf.setOutputKeyClass(Text.class);
	    conf.setOutputValueClass(LongWritable.class);
	
	    conf.setMapperClass(MiningTWUMapper.class);
	    conf.setCombinerClass(MiningTWUReducer.class);
	    conf.setReducerClass(MiningTWUReducer.class);
	
	    conf.setInputFormat(TextInputFormat.class);
	    conf.setOutputFormat(TextOutputFormat.class);
	
	    FileInputFormat.setInputPaths(conf, new Path(inFilePath));
	    FileOutputFormat.setOutputPath(conf, new Path(outFilePath));
	
	    JobClient.runJob(conf);
	}
	  
	public void runUtilityCount(String inFilePath, String outFilePath) throws Exception {
		JobConf conf = new JobConf(UtilityCount.class);
		conf.setJobName("UtilityCount");
	
	    conf.setOutputKeyClass(Text.class);
	    conf.setOutputValueClass(LongWritable.class);
	
	    conf.setMapperClass(UtilityCountMapper.class);
	    conf.setCombinerClass(UtilityCountReducer.class);
	    conf.setReducerClass(UtilityCountReducer.class);
	
	    conf.setInputFormat(TextInputFormat.class);
	    conf.setOutputFormat(TextOutputFormat.class);
	
	    FileInputFormat.setInputPaths(conf, new Path(inFilePath));
	    FileOutputFormat.setOutputPath(conf, new Path(outFilePath));
	    
	    JobClient.runJob(conf);
	}

}
