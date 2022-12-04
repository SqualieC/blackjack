package BlackJackWoo;
import java.util.Scanner;
public class Blackjack{
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        
        /*
         * Process:
         * 1. set the table
         * 1.5. place bets
         * 2. dealer deals
         * 3. go through each players turn
         * 4. dealer's turn
         * 5. collect cards
         * 5.5. Payout bets
         * 5.6. check if bankrupt + check if need shuffle
         * 6. repeat from step 2*
         * *If half deck or more has been used, shuffle after collecting cards*
         */


        //Set up table
        boolean gameInProgress = true;
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        Table table = new Table();


        //Player bob = new Player("bob", 1);
        //bob.getHand().printHand();
        





        //repeat
        while(gameInProgress){
            //take bets
            
            for(int i = 0; i < table.getPlayerCount(); i++){
                int bet = 0;
                System.out.print("(" + table.getPlayers()[i].getName() + ") Bank: $" + table.getPlayers()[i].getBank() + '\n' + "Enter bet: ");
                try{
                    bet = Blackjack.in.nextInt();
                }
                catch(Exception e){
                    gameInProgress = false;
                    System.out.println("Game over");
                    break;
                }
                
                table.getPlayers()[i].setBet(bet);
            }
            if(gameInProgress == false){
                break;
            }
            System.out.println("All bets have been taken");
            System.out.println("------------------------------------------------");

            //dealer deals
            dealer.deal(table, deck);


            //playerTurns
            for(int i = 0; i < table.getPlayerCount(); i++){
                System.out.println(table.getPlayers()[i].getName() + "'s turn");
                table.getPlayers()[i].playTurn(deck, dealer);
            }

            //dealer turn
            dealer.playDealerTurn(deck);
            
            //Pay out bets
            for(int i = 0; i < table.getPlayerCount(); i++){
                //player wins
                if(table.getPlayers()[i].getHand().getHandTotal() > dealer.getDealer().getHand().getHandTotal()){
                    //if(table.getPlayers()[i])
                    System.out.println(table.getPlayers()[i].getName() + " bet $" + table.getPlayers()[i].getBet() + "  and won $" + (table.getPlayers()[i].getBet() + (table.getPlayers()[i].getBet()*table.getPlayers()[i].getMult())));
                    table.getPlayers()[i].payBet();
                    System.out.print("(" + table.getPlayers()[i].getName() + ") Bank: $" + table.getPlayers()[i].getBank());

                }
                //player loses
                else if(table.getPlayers()[i].getHand().getHandTotal() <= dealer.getDealer().getHand().getHandTotal()){
                    System.out.println(table.getPlayers()[i].getName() + " bet $" + table.getPlayers()[i].getBet() + "  and lost $" + table.getPlayers()[i].getBet());
                    System.out.print("(" + table.getPlayers()[i].getName() + ") Bank: $" + table.getPlayers()[i].getBank());
                }
            }

            //collect cards
            for(int i = 0; i < table.getPlayerCount(); i++){
                table.getPlayers()[i].getHand().clear();
            }
            dealer.getDealer().getHand().clear();
            System.out.println('\n' + "Table Cleared");
            System.out.println("------------------------------------------------");
            //dealer = new Dealer();
            //check for shuffle
            if(deck.needShuffle() == true){
                deck.fillDeck();
                deck.shuffle();
            }
            //check for poor
            gameInProgress = false;
            for(int i = 0; i < table.getPlayerCount(); i++){
                System.out.println(table.getPlayers()[i].getName() + "'s turn");
                //if any player has money, game continues
                if(table.getPlayers()[i].getBank() > 0){
                    gameInProgress = true;
                }
            }
        }

    }
}