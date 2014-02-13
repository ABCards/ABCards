package com.example.abcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck 
{
	List<Card> deck1;	 
	
	Deck()
	{
		build_ordered_deck();
	}

	public void shuffle_deck()
	{
		/*Creates a arraylist of randomly sorted card in the deck. 
		 * The arrayList deck should contain 52 unique cards in random
		 * order. 
		 */
		Collections.shuffle(this.deck1);
	}
	
	public void build_ordered_deck()
	{
		/*Creates a deck of cards in order they are listed in drawables.
		 * This may not be needed for our program, but if it is
		   the arrayList deck should contain 52 cards in order.
		 */
		deck1 = new ArrayList<Card>();
		// May need to add each individual image in to deck....
	}
	
	public Card deal_top_car()
	{
		/*This should return the top card of the arrayList deck and 
		 * remove it from the ArrayList so that the card can not be
		 * dealt again.
		 */
		Card temp = deck1.get(deck1.size() - 1);
		deck1.remove(deck1.size() - 1);
		return temp;
	}
}
