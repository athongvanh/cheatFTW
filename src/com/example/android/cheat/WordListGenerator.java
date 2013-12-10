package com.example.android.cheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WordListGenerator {
	static File m_dir;
	static PrintWriter[] m_wordfiles;
	
	private static void createDirectory() {
		m_dir = new File(WordList.WORDLIST_DIRECTORY);
		if (!m_dir.isDirectory())
			m_dir.mkdir();
	}
	
	private static void createFiles() {
		try {
			m_wordfiles = new PrintWriter[16];
			for (int i=2; i<=15; i++){
				File f = new File(m_dir, WordList.getWordListFilename(i));
				m_wordfiles[i]=new PrintWriter(new BufferedWriter(new FileWriter(f)));
			}
		}
		catch (IOException ioe) {
			System.err.println("Unable to create wordlist file: "+ioe);
			ioe.printStackTrace();
			System.exit(1);
		}
		
		
	}
	
	private static void closeFiles() {
		for (int i=2;i<=15; i++) {
			m_wordfiles[i].close();
		}
	}
		
	public static void main(String []args){
		if (args.length!=1){
			System.out.println("Usage: java WordGenereator <wordlist file>");
			System.exit(1);
		}
		System.out.println("Generating wordlist files.");
		createDirectory();
		createFiles();
		try{
			BufferedReader wordlist = new BufferedReader(new FileReader(args[0]));
			String line;
			while((line = wordlist.readLine()) !=null)
				if (line.length()>=2 && line.length() <=15)
					m_wordfiles[line.length()].println(line);
		}
		catch (IOException ioe) {
			System.err.println("Unexpected IOException while generating wordlists: "+ioe);
			ioe.printStackTrace();
		}
		closeFiles();
	}
}
