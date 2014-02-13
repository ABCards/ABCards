package com.example.abcards;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class BlackJack extends Activity {
	
	Deck deck = new Deck();
	int dealer_count = 0;
	int player_count = 0;
	int dealer_ace_count = 0;
	int player_ace_count = 0;
	Card dealers_second_card;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_black_jack, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void deal(View view)
    {   
    	dealer_ace_count = 0;
    	player_ace_count = 0;
    	player_count = 0;
    	dealer_count = 0;
    	
    	if(deck.getDeck().size() < 15) 
    	{
    		deck = new Deck();
    		deck.shuffle_deck();
    	}
    	
    	//Cards that come visible after deal
    	
    	//players first card
    	Card temp_card = deck.deal_top_car();   	
    	final ImageView player1 = (ImageView) findViewById(R.id.player_hand1);        
        player1.setImageResource(temp_card.getImage());
        player1.setVisibility(0);
        if(temp_card.getBJN() == 1)
        {
        	player_count += 11;
        	player_ace_count++;
        }
        else player_count += temp_card.getBJN();
        
        //dealers first card
        temp_card = deck.deal_top_car();
    	final ImageView dealer1 = (ImageView) findViewById(R.id.dealer_hand1);        
        dealer1.setImageResource(temp_card.getImage());
        dealer1.setVisibility(0);        
        if(temp_card.getBJN() == 1)
        {
        	dealer_count += 11;
        	dealer_ace_count++;
        }
        else dealer_count += temp_card.getBJN();
        
        //players second card
        temp_card = deck.deal_top_car();
    	final ImageView player2 = (ImageView) findViewById(R.id.player_hand2);        
        player2.setImageResource(temp_card.getImage());
        player2.setVisibility(0);
        if(temp_card.getBJN() == 1 && player_ace_count == 1)
        {
        	player_count += 1;        	
        }
        else if(temp_card.getBJN() == 1)
        {
        	player_count += 11;
        	player_ace_count++;
        }
        else player_count += temp_card.getBJN();
        
        //dealers second card        
        dealers_second_card = deck.deal_top_car();
    	final ImageView dealer2 = (ImageView) findViewById(R.id.dealer_hand2);        
        dealer2.setImageResource(R.drawable.rb);
        dealer2.setVisibility(0); 
        /*if(temp_card.getBJN() == 1 && dealer_ace_count == 1)
        {
        	dealer_count += 1;        	
        }
        else if(temp_card.getBJN() == 1)
        {
        	dealer_count += 11;
        	dealer_ace_count++;
        }
        else dealer_count += temp_card.getBJN();*/
        
        //score desplayed
        final TextView score = (TextView) findViewById(R.id.dealer_count);
        score.setText(Integer.toString(dealer_count));
        score.setTextColor(Color.RED);
        score.setVisibility(0);
        
        final TextView scoreP = (TextView) findViewById(R.id.player_count);
        scoreP.setText(Integer.toString(player_count));
        scoreP.setTextColor(Color.RED);
        scoreP.setVisibility(0);
    }

}
