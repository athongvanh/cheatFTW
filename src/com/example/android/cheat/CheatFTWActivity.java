package com.example.android.cheat;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CheatFTWActivity extends Activity {

	public HashMap<String, Integer> Bank = new HashMap<String, Integer>();
	public HashMap<String, Integer> Values = new HashMap<String, Integer>();
	public GridLayout board;
	public TextView rtext;
	public TextView vtext;
	Button delete;
	public String banktileselected;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat_ftw);
		
		scrabbankinit(Bank);
		scrabvalinit(Values);
		delete = (Button) findViewById(R.id.bdelete);
		rtext = (TextView) findViewById(R.id.rtext);
		vtext = (TextView) findViewById(R.id.vtext);
		delete.setVisibility(View.INVISIBLE);
		rtext.setVisibility(View.INVISIBLE);
		vtext.setVisibility(View.INVISIBLE);
		board = (GridLayout)findViewById(R.id.board);
		boardinit(board);
		
		
	}
	
	private HashMap<String, Integer> scrabbankinit(HashMap<String,Integer> b) {
		b.put("A", 9);
		b.put("B", 2);
		b.put("C", 2);
		b.put("D", 4);
		b.put("E", 12);
		b.put("F", 2);
		b.put("G", 3);
		b.put("H", 2);
		b.put("I", 9);
		b.put("J", 1);
		b.put("K", 1);
		b.put("L", 4);
		b.put("M", 2);
		b.put("N", 6);
		b.put("O", 8);
		b.put("P", 2);
		b.put("Q", 1);
		b.put("R", 6);
		b.put("S", 4);
		b.put("T", 6);
		b.put("U", 4);
		b.put("V", 2);
		b.put("W", 2);
		b.put("X", 1);
		b.put("Y", 2);
		b.put("Z", 1);
		b.put("BLANK", 2);
		
		return b;
	}
	
	private HashMap<String, Integer> scrabvalinit(HashMap<String,Integer> b) {
		b.put("A", 9);
		b.put("B", 2);
		b.put("C", 2);
		b.put("D", 4);
		b.put("E", 12);
		b.put("F", 2);
		b.put("G", 3);
		b.put("H", 2);
		b.put("I", 9);
		b.put("J", 1);
		b.put("K", 1);
		b.put("L", 4);
		b.put("M", 2);
		b.put("N", 6);
		b.put("O", 8);
		b.put("P", 2);
		b.put("Q", 1);
		b.put("R", 6);
		b.put("S", 4);
		b.put("T", 6);
		b.put("U", 4);
		b.put("V", 2);
		b.put("W", 2);
		b.put("X", 1);
		b.put("Y", 2);
		b.put("Z", 1);
		b.put("BLANK", 2);
		
		return b;
	}
	
	private void boardinit(GridLayout v){
		for(int i=0;i<225;i++){
			ImageView empty = new ImageView(getApplicationContext());
			empty.setBackground(getResources().getDrawable(R.drawable.empty));
			empty.setTag("empty");
			empty.setClickable(true);
			empty.setId(i);
			empty.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(!(v.getTag().equals(null))){
					if(v.getTag().equals("empty")&&!(banktileselected==null)){
						delete.setVisibility(View.INVISIBLE);
						int remaining = Bank.get(banktileselected);
						rtext.setVisibility(View.VISIBLE);
						vtext.setVisibility(View.VISIBLE);
						if(remaining!=0){
								v.setTag(banktileselected);
								v.setBackground(getResources().getDrawable(letterid(banktileselected)));
								remaining--;
								Bank.put(banktileselected, remaining);
								rtext.setText("Remaining: "+remaining);
								
						}
					}else if(!v.getTag().equals("empty")){
						rtext.setVisibility(View.INVISIBLE);
						vtext.setVisibility(View.INVISIBLE);
						banktileselected=null;
						BankDeselect();
						DeleteTile(v.getId());
					}
				}
				}
			});
			v.addView(empty, i);
			
		}
	}

	private void BankDeselect(){
		LinearLayout v = (LinearLayout) findViewById(R.id.tilebank);
		for(int i=0;i<v.getChildCount();i++){
			v.getChildAt(i).setBackgroundColor(getApplicationContext().getResources().getColor(R.color.clear));
		}
	}
	
	public void BankTileClick(View v){
		BankDeselect();
		v.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.lime));
		banktileselected= v.getContentDescription().toString();
		int rem = Bank.get(banktileselected);
		rtext.setVisibility(View.VISIBLE);
		vtext.setVisibility(View.VISIBLE);
		delete.setVisibility(View.INVISIBLE);
		rtext.setText("Remaining: "+rem);

	}
	
	private int letterid(String key){
		int id = 0;
		if(key.equals("A")) id = R.drawable.a;
		else if(key.equals("B")) id = R.drawable.b;
		else if(key.equals("C")) id = R.drawable.c;
		else if(key.equals("D")) id = R.drawable.d;
		else if(key.equals("E")) id = R.drawable.e;
		else if(key.equals("F")) id = R.drawable.f;
		else if(key.equals("G")) id = R.drawable.g;
		else if(key.equals("H")) id = R.drawable.h;
		else if(key.equals("I")) id = R.drawable.i;
		else if(key.equals("J")) id = R.drawable.j;
		else if(key.equals("K")) id = R.drawable.k;
		else if(key.equals("L")) id = R.drawable.l;
		else if(key.equals("M")) id = R.drawable.m;
		else if(key.equals("N")) id = R.drawable.n;
		else if(key.equals("O")) id = R.drawable.o;
		else if(key.equals("P")) id = R.drawable.p;
		else if(key.equals("Q")) id = R.drawable.q;
		else if(key.equals("R")) id = R.drawable.r;
		else if(key.equals("S")) id = R.drawable.s;
		else if(key.equals("T")) id = R.drawable.t;
		else if(key.equals("U")) id = R.drawable.u;
		else if(key.equals("V")) id = R.drawable.v;
		else if(key.equals("W")) id = R.drawable.w;
		else if(key.equals("X")) id = R.drawable.x;
		else if(key.equals("Y")) id = R.drawable.y;
		else if(key.equals("Z")) id = R.drawable.z;
		else if(key.equals("BLANK")) id = R.drawable.tile;
		
		return id;
	}
	
	public void DeleteTile(int position){
		delete.setVisibility(View.VISIBLE);
		final ImageView cur = (ImageView) board.getChildAt(position);;
		ImageView v;
		for(int i =0; i<225; i++){
			v = (ImageView) board.getChildAt(i);
			if(i!=position){
				v.setImageResource(R.drawable.empty);
			}
		}
		cur.setImageResource(R.drawable.boardselected);
		delete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int rem = Bank.get(cur.getTag().toString());
				rem++;
				Bank.put(cur.getTag().toString(), rem);
				cur.setBackground(getResources().getDrawable(R.drawable.empty));
				cur.setTag("empty");
				cur.setImageResource(R.drawable.empty);
				
				
			}
		});
		
		
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
