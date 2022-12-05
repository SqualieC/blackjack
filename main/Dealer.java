package source;
import java.util.concurrent.TimeUnit;
public class Dealer {
    Player dealer;
    public Dealer(){
        dealer = new Player("Dealer", 0);

    }
    public Player getDealer(){
        return dealer;
    }
    public void playDealerTurn(Deck dec){
        System.out.println("------------------------------------------------");
        System.out.println("Dealer's turn");
            long delay = 1;
            boolean activeTurn = true;
            boolean bust = false;
            //String move = "";
            //int moveNum = 0;
            if(dealer.getHand().getHandTotal() == 21){
                dealer.getHand().printHand();
                System.out.println("Total value: " + dealer.getHand().getHandTotal() + " Dealer has Blackjack!");
                return;
            }
            while(activeTurn){
                if(dealer.getHand().getHandTotal() == 21){
                    activeTurn = false;
                }
                else if(dealer.getHand().getHandTotal() > 21){
                    bust = true;
                    activeTurn = false;
                    //break;
                }
                dealer.getHand().printHand();
                System.out.println("Total value: " + dealer.getHand().getHandTotal());
                if(bust){
                    System.out.println("Dealer busts.");
                    dealer.getHand().clear();
                    System.out.println("------------------------------------------------");
                    break;
                }
                System.out.println("------------------------------------------------");
                //Dealer playing
                    try {
                        TimeUnit.SECONDS.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(dealer.getHand().getHandTotal() < 17){
                        System.out.println("Dealer hits.");
                        dealer.getHand().addCard(dec.pull());
                    }
                    else if(dealer.getHand().getHandTotal() >= 17 && dealer.getHand().getHandTotal() < 22){
                        System.out.println("Dealer stands. Turn over.");
                        System.out.println("------------------------------------------------");
                        activeTurn = false;
                    }
                }
            }
    

    public void deal(Table tab, Deck dec){
        for(int i = 0; i < (tab.getPlayerCount()+1)*2; i++){

            if(i == 0 || i == tab.getPlayerCount()+1){
                dealer.getHand().addCard(dec.pull());
            }
            else if(i < tab.getPlayerCount()+1){
                tab.getPlayers()[i-1].addCardToHand(dec.pull());
            }
            else if(i > tab.getPlayerCount()+1 && i < tab.getPlayerCount()*2 + 2){
                tab.getPlayers()[(i)-2 -tab.getPlayerCount()].addCardToHand(dec.pull());
            }
        }
    }

    
    
}
