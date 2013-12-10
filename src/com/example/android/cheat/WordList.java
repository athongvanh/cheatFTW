package com.example.android.cheat;

import java.io.*;
import java.util.Arrays;
import java.text.DecimalFormat;

public class WordList {
	public static String WORDLIST_DIRECTORY = "wordlist";
	private static WordList m_wordList;

	private static Word[][] m_words;

	static String getWordListFilename(int numLetters) {
		DecimalFormat decimalFormat = new DecimalFormat("00");
		return "words." + decimalFormat.format(numLetters);
	}
	private WordList() throws CheatException {
		m_words = new Word[16][];
		System.out.println("Opening WordList...");
		try {
			File wordListDirectory = new File(WORDLIST_DIRECTORY);
			for (int i = 2; i <= 15; i++) {
				File file = new File(wordListDirectory, getWordListFilename(i));
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				// Count the number of lines in the file....
				int numWords = 0;
				while (bufferedReader.readLine() != null)
					numWords++;
				fileReader.close();

				// Now allocate space in the m_words array and read the words
				// into memory
				m_words[i] = new Word[numWords];
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				for (int counter = 0; counter < numWords; counter++)
					m_words[i][counter] = new Word(bufferedReader.readLine());
			}
		}

		catch (IOException ioe) {
			throw new ScrabaidException("An error occurred when reading in the wordlist. (IOException: " + ioe.getMessage() + ")\nMake sure you have generated the word lists using the WordListGenerator program");
		}
	}
	public boolean isWord(Word w) {
		return isWord(w.getString());
	}
	public boolean isWord(String s) {
		if (s.length() < 2 || s.length() > 15)
			return false;
		Word[] w = m_words[s.length()];
		return Arrays.binarySearch(w, s) >= 0;
	}

	public Word[][] getWords() {
		return m_words;
	}
	public int getNumWords() {
		return m_words.length;
	}
	public synchronized static WordList getInstance() throws ScrabaidException {
		if (m_wordList == null) {
			m_wordList = new WordList();
		}
		return m_wordList;
	}
	public static void main(String []args) {
		try {
			WordList wordList = getInstance();
			System.out.println(wordList.isWord("crayon"));
			System.out.println(wordList.isWord("qrztru"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
