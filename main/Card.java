package source;
public class Card{
    
    private String cardName = "";
    private String suit = "";
    private int value = 0;
    
    //Constructor
    public Card(String cardName, String suit, int value){
        this.cardName = cardName;
        this.suit = suit;
        this.value = value;
    }
    public Card(){
        cardName = "";
        suit = "";
        value = 0;
    }
    
    public void setName(String x){
        cardName = x;
        
    }
    
    public String getName(){
        return cardName;
    }

    public void setSuit(String y){
        suit = y;
        
    }

    public String getSuit(){
        return suit;
    }
    
    
    public int getCardValue(){
        return value;
    }
    
    public void setCardValue(int value){
        this.value = value;
        
    }
    
    public String toString(){
        
        return(cardName + " of " + suit + " (" + value + ")");
    }
}