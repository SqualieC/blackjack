package BlackJackWoo;
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
        //try (Scanner input = new Scanner(System.in)) {
            long delay = 2;
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
                    //System.out.println("You bust.");
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
                //System.out.println("Dealer shows: " + dealer.getDealer().getHand().getCard(1).toString());
                //System.out.println(name + " what is your move? [ H (Hit) / S (Stand) / D (Double down)"  /*+ " / SP (Split)"*/ + "]");
                //input.nextLine();
                //while(true){
                    //try{
                        //move = Blackjack.in.nextLine();
                        //move.toUpperCase();
                        //if(move.equals("H") || move.equals("S") || move.equals("D") || move.equals("SP")){
                        //    break;
                        //}
                        //throw new Exception("Invalid");
                    //}
                    /* 
                    catch(Exception e){
                        System.out.println("Invalid response, try again: ");
                    }*/
                //}
                //Dealer playing
                    try {
                        TimeUnit.SECONDS.sleep(delay);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
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

                    /* 
                switch (move){
                    case "S":
                        System.out.println("Turn over.");
                        activeTurn = false;
                        break;
                    case "H":
                        dealer.getHand().addCard(dec.pull());
                        break;*/
                        /* 
                    case "D":
                        if(moveNum == 0)bet *= 2;
                        break;*/
                    
                }
            }
        //}
    

    public void deal(Table tab, Deck dec){
        for(int i = 0; i < (tab.getPlayerCount()+1)*2; i++){

            if(i == 0 || i == tab.getPlayerCount()+1){
                dealer.getHand().addCard(dec.pull());
                //System.out.println("dealdeal is working" + -1);
            }
            else if(i < tab.getPlayerCount()+1){
                tab.getPlayers()[i-1].addCardToHand(dec.pull());
                //System.out.println("1st card is working" + (i-1));
            }
            else if(i > tab.getPlayerCount()+1 && i < tab.getPlayerCount()*2 + 2){
                tab.getPlayers()[(i)-2 -tab.getPlayerCount()].addCardToHand(dec.pull());
                //System.out.println("2nd card is working" + ((i)-2 -tab.getPlayerCount()));
            }
        }
    }

    
    
}
