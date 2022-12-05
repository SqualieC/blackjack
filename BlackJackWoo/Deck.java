package BlackJackWoo;

import java.util.Random;

public class Deck{
    
    public final String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public final String[] suits = {"Spades","Hearts","Clubs","Diamonds"};
    public final int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    
    private int cardsTaken = 0;
    Card[] deck = new Card[52*6];
    
    public Deck(){
        this.fillDeck();
        
    }
    public Card[] getDeck(){
        return deck;

    }
    private void swapCards(int index1, int index2){	
		Card hold;

		hold = deck[index1];
		deck[index1] = deck[index2];
		deck[index2] = hold;
	}

	public void shuffle(){
		Random randNum = new Random();
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < deck.length; j++) {
				swapCards(i, randNum.nextInt(312));
			}
		}
	}
    
    public Card pull(){
        Random randNum = new Random();
        int randomCardNum;
        Card returnedCard;
        while(true){

            randomCardNum = randNum.nextInt(312);
            if(deck[randomCardNum].getCardValue() != -1){
                returnedCard = new Card(deck[randomCardNum].getName(), deck[randomCardNum].getSuit(), deck[randomCardNum].getCardValue());
                deck[randomCardNum].setCardValue(-1);
                break;
            }

        }
        return returnedCard;
    }

    public boolean needShuffle(){
        if(cardsTaken > deck.length/2 - 1){
            return true;
        }
        return false;
    }

    public void fillDeck(){
        for(int i = 0; i < deck.length; i++){
            deck[i] = new Card();

        }

        int counter = 0;
        for(int i = 0; i < deck.length/13; i++){
            for(String name:names){
                deck[counter].setName(name);
                counter++;
            }
        }
        counter = 0;
        for(int i = 0; i < deck.length/4; i++){
            for(String suit:suits){
                deck[counter].setSuit(suit);
                counter++;
            }
        }
        counter = 0;
        for(int i = 0; i < deck.length/13; i++){
            for(int val:values){
                deck[counter].setCardValue(val);
                counter++;
            }
        }
    } 
}