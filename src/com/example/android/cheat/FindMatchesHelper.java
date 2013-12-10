package com.example.android.cheat;

import java.util.Vector;

public class FindMatchesHelper {

	Vector startMatch(char []trayTiles, int numBlanks) {
		Vector firstMatch = new Vector();
		
		Vector v = m_patternLookup.scrabbleStartSearch(trayTiles, numBlanks);
		for(int i=0; i<v.size();i++){
			matchWin win = (matchWin) v.elementAt(i);
			win.row=7;
			firstMatch.add(win);
		}
	}
	
}
