package com.example.abcards;

public class Card 
{
	int image;
	int blackjack_number;
	
	Card(int image, int number)
	{
		this.image = image;
		this.blackjack_number = number;
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
