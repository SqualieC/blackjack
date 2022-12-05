package BlackJackWoo;

public class Hand {
    int handVal = 0;
    int nextCardPos = 0;
    Card[] cards = new Card[12];

    public Hand(){
        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card();
        }
        
    }
    public void addCard(Card z){
        cards[nextCardPos] = z;
        nextCardPos++;

    }

    public Card getCard(int position){
        return cards[position];
    }

    public int getHandTotal(){
        int total = 0;
        int acesInHand = 0;
        int[] aceLocations = new int[12];
        for(int i = 0; i < cards.length; i++){
            //pushing off dealing with aces
            if(cards[i].getName() != "Ace"){
                total += cards[i].getCardValue();
            }
            else{
                aceLocations[acesInHand] = i;
                acesInHand++;

            }
        }
        //dealing with aces
        if(acesInHand > 0){
            for(int i = 0; i < acesInHand; i++){
                if(total + 11 < 22){
                    total += 11;
                    cards[aceLocations[i]].setCardValue(11);
                }
                else{
                    total += 1;
                    cards[aceLocations[i]].setCardValue(1);
                }
            }
        }
        return total;
    }

    public void clear(){
        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card();
        }
        nextCardPos = 0;
    }

    public int getCardsInHand(){
        int cardsInHand = 0;
        for(Card card: cards){
            if(card.getCardValue() != 0){
                cardsInHand++;
            }
        }
        return cardsInHand;
    }

    public void printHand(){
        
        for(int i = 0; i < this.getCardsInHand(); i++){
            System.out.println(cards[i].toString());
        }

    }

}
