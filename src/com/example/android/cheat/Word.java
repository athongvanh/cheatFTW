package com.example.android.cheat;

import java.util.*;
import java.util.regex.Pattern;

public class Word {
	private String m_word;
	public Word(String s) {
		m_word = s;
	}
	public String [] getPatternStrings() {
		char[] characters = m_word.toCharArray();
		char[] blankPattern = "               ".toCharArray();
		String [] patterns;

		int wordLength = m_word.length();	// Local variable is faster than method call

		// Go through the word, and generate possible patterns by "switching" on and off
		// each possible character between wildcard (blank), and the actual character
		int n = (1 << wordLength) - 1;
		patterns = new String[n];
		for (int counter = 0; counter < n; counter++) {
			char [] newCharacters = (char[]) characters.clone();
			for (int bit = 0; bit < wordLength; bit++) {
				if ((counter & (1 << bit)) != 0) {
					newCharacters[bit] = ' ';
				}
			}
			patterns[counter] = new String(newCharacters);
		}
		return patterns;
	}

	public String getString() {
		return m_word;
	}
	public Pattern[] getPatterns() {
		String [] stringPatterns = getPatternStrings();
		Pattern[] patterns = new Pattern[stringPatterns.length];
		for (int i = 0; i < stringPatterns.length; i++)
			patterns[i] = new Pattern(stringPatterns[i]);
		return patterns;
	}
	public int length() {
		return m_word.length();
	}

	public static void main(String []args) {
		Word w = new Word("catalogue");
		Pattern[] p = w.getPatterns();
		System.out.println(p.length);
	}
	public String toString() {
		if (m_word.length() > 15)
			return m_word;

		char []c = "               ".toCharArray();
		char []c2 = m_word.toCharArray();
		System.arraycopy(c2,0,c,0,c2.length);
		return new String(c);
	}
	public int compareTo(Object o) {
		if (o instanceof String) {
			return m_word.compareTo(o);
		}
		else {
			Word w = (Word) o;
			return m_word.compareTo(w.m_word);
		}
	}
}
