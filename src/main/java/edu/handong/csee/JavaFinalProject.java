package edu.handong.csee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import edu.handon.csee.utils.Utils;
import edu.handon.csee.utils.ZipReader;
import edu.handong.csee.customized.LinkedList;

public class JavaFinalProject  {
	
	private String inputPath, outputPath;
	private boolean help;
	private HashMap<String, LinkedList<String>> zip1 = new HashMap<String, LinkedList<String>>();
	private HashMap<String,LinkedList<String>> zip2 = new HashMap<String, LinkedList<String>>();
	 
	 
	public void run(String[] args) throws IOException {
		Options options = createOptions();

		if(parseOptions(options, args)) {
			if (help){
				printHelp(options);

				return;
			}
		
		ZipReader zipReader = new ZipReader();
		zipReader.readFileInZip(inputPath);
		
		
		zip1 = zipReader.getZip1();
		zip2 = zipReader.getZip2();
		Map<String, LinkedList<String>> sortedZip1 = new TreeMap<String, LinkedList<String>>(zip1);
		Map<String, LinkedList<String>> sortedZip2 = new TreeMap<String, LinkedList<String>>(zip2);

		Utils.writeAFile(sortedZip1,sortedZip2,outputPath);
		
	}
}

	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "Java Final Project";
		String footer = "" ; // Leave this empty.;
		formatter.printHelp("JavaFinalProject", header, options, footer, true);
		
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);
			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;

	}

	private Options createOptions() {
		Options options = new Options();
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg()
				.argName("Input path")
				.required()
				.build());

		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg()
				.argName("Output path")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Show a Help page")
				.argName("Help")
				.build());

		return options;
	}

	

	
}
	