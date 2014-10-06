package idb.PMiningTWU;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class PMiningTWUDriver {
	
	public static String InFilePath;
	public static String OutFilePath;
	public static int MinUtility;


	public static void main(String[] args) throws Exception {
		run(args);
		
		PMiningTWU pmTWU = new PMiningTWU();
		pmTWU.startPMiningTWU();
	}
	
	public static int run(String[] args){
		Options options = new Options();
		options.addOption("i", true, "[input] input file or directory");
		options.addOption("o", false, "[output] output directory");
		options.addOption("u", true, "[Minimum Utility] set the minimum utility");
		
		CommandLineParser parser = new BasicParser();
		try {
			CommandLine cmd = parser.parse( options, args);
			InFilePath = cmd.getOptionValue("i");
			OutFilePath = cmd.getOptionValue("o");
			MinUtility = Integer.parseInt(cmd.getOptionValue("u"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(InFilePath);
		System.out.println(OutFilePath);
		System.out.println(MinUtility);
		return 0;
	}

}
