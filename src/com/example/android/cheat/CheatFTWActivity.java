package com.example.android.cheat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class CheatFTWActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat_ftw);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()) {
		case R.id.action_new:
			newGame();
			break;
		case R.id.action_load:
			loadGame();
			break;
		case R.id.action_save:
			saveGame();
			
		default:
		break;
		}
		
		return true;
	}

	private void saveGame() {
		Toast.makeText(this, "Save Game selected", Toast.LENGTH_SHORT).show();
		
	}

	private void loadGame() {
		Toast.makeText(this, "Load Game selected", Toast.LENGTH_SHORT).show();
			
	}

	private void newGame() {
		Toast.makeText(this, "New Game selected", Toast.LENGTH_SHORT).show();
				
	}
	
}
