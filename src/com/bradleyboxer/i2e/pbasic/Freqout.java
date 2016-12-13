package com.bradleyboxer.i2e.pbasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Freqout {
	
	public boolean success = false;
	
	public Freqout(String dir) {
		success = runFreqout(dir);
	}
	
	public String getFreqoutCompleted() {
		return (success ? "Freqout Freaked Out! (Success!)" : "Freqout Freaked Out! (Error!)");
	}
	
	public boolean runFreqout(String directory) {
		System.out.println(directory);
	   	String line = "";
	    String csvSplitBy = ",";
	    String inputDirectory = directory.replace("\\", "/"); //corrects the directory
	    String outputDirectory = (inputDirectory.substring(0, inputDirectory.length()-4))+"-output.txt"; //gets the output filename
	    BufferedReader br = null;
	    
	    
	    try {  
	      	br = new BufferedReader(new FileReader(inputDirectory));
	        	
        	File file = new File(outputDirectory);
        	FileWriter fw = new FileWriter(file, true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw, true);
        	file.createNewFile();	
	        	
        	while ((line = br.readLine()) != null) {
	        	String[] splitStrings = line.split(csvSplitBy);
	        	String freqOutput = null;
	        	String timeOutput = null;
	        	
	        	try {
	        		freqOutput = "FREQOUT Spkr, " + splitStrings[1] + ", " + splitStrings[0] + ", " + splitStrings[2];
	        		timeOutput = "PAUSE 10";
		  
	        	} catch (ArrayIndexOutOfBoundsException ae) {
	        		freqOutput = "FREQOUT Spkr, " + splitStrings[1] + ", " + splitStrings[0];
	        		timeOutput = "PAUSE 10";
	        	}
	        	
	        	System.out.println(freqOutput);
	            System.out.println(timeOutput);
	            pw.println(freqOutput);
	            pw.println(timeOutput);
	        	
        	}
        pw.close();
        return true;
	    } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	    }
	}
	
}
