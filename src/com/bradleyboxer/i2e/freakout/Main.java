package com.bradleyboxer.i2e.freakout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		String csvFile = "C:\\CSV\\freqout.csv";
	   	String line = "";
	    String cvsSplitBy = ",";
	    BufferedReader br = null;
	    
	    try {  
	      	br = new BufferedReader(new FileReader(csvFile));
	        	
	        String filepath = "C:\\CSV\\freqout-output.txt";
        	File file = new File(filepath);
        	FileWriter fw = new FileWriter(file, true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw, true);
        	file.createNewFile();	
	        	
        	while ((line = br.readLine()) != null) {
	        	String[] splitStrings = line.split(cvsSplitBy);
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
	    } catch (IOException e) {
	            e.printStackTrace();
	    }
	}
}

