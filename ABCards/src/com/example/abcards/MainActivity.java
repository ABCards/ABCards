package com.example.abcards;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {	
	
	public final int saved_coins_default = 1000;
	public int coin = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences sharedPref = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);        
        coin = sharedPref.getInt(getString(R.string.saved_coins), saved_coins_default);
        if(coin == 0) coin = 1000;
        final TextView textViewToChange = (TextView) findViewById(R.id.textView2);
        textViewToChange.setText(Integer.toString(coin));
    }
    
    @Override
    protected void onStop(){
       super.onStop();
       
       SharedPreferences sharedPref = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
       SharedPreferences.Editor editor = sharedPref.edit();
       editor.putInt(getString(R.string.saved_coins), coin);
       editor.commit();
    }
    
    @Override
    protected void onPause(){
       super.onStop();
       
       SharedPreferences sharedPref = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
       SharedPreferences.Editor editor = sharedPref.edit();
       editor.putInt(getString(R.string.saved_coins), coin);
       editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void sendBlackJack(View view)
    {
    	Intent intent = new Intent(this, BlackJack.class);
    	startActivity(intent);
    }
}
