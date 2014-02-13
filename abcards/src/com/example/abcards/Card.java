package com.example.abcards;

public class Card 
{
	int image;
	int blackjack_number;
	
	Card(int image, int number)
	{
		this.image = image;
		if(number == 11 || number == 12 || number == 0)
			blackjack_number = 10;
		else blackjack_number = number;
	}
	
	public int getImage()
	{
		return image;
	}
	public int getBJN()
	{
		return blackjack_number;
	}
	public void setImage(int image)
	{
		this.image = image;
	}
	public void setBJN(int number)
	{
		this.blackjack_number = number;
	}
}
