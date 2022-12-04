package BlackJackWoo;
//import java.util.Scanner;

public class Player {

    private double defaultBank = 1000;

    private double blackjackMultiplier = 1.0;
    private String name;
    private int seat; 
    private Hand hand;
    private double bank;
    private double bet = 0;
    private boolean bust = false;
    public Player(String name, int seat){
        this.name = name;
        this.seat = seat;
        this.hand = new Hand();
        bank = defaultBank;

    }
    public double getMult(){
        return blackjackMultiplier;
    }
    public void setBet(int x){
        
        if(x > bank || bet < 0){
            bet = bank;
            bank -= bet;
        }
        else{
            bet = x;
            bank -= bet;
        }
    }
    public void payBet(){
        bank += bet*2;
    }
    public double getBet(){
        return bet;
    }
    public boolean busted(){
        return bust;
    }

    public String getName(){
        return name;
    }

    public int getSeat(){
        return seat;
    }

    public Hand getHand(){
        return hand;
    }

    public void addCardToHand(Card x){
        hand.addCard(x);
    }
    public double getBank(){
        return bank;
    }
    
    public void playTurn(Deck dec, Dealer dealer){
        //try (Scanner input = new Scanner(System.in)) {
            blackjackMultiplier = 1.0;
            boolean activeTurn = true;
            bust = false;
            String move = "";
            int moveNum = 0;
            if(hand.getHandTotal() == 21){
                hand.printHand();
                System.out.println("Total value: " + hand.getHandTotal() + " Blackjack!");
                return;
            }
            while(activeTurn){
                if(hand.getHandTotal() == 21){
                    activeTurn = false;
                    blackjackMultiplier = 1.5;
                }
                else if(hand.getHandTotal() > 21){
                    //System.out.println("You bust.");
                    bust = true;
                    activeTurn = false;
                    //break;
                }
                hand.printHand();
                System.out.println("Total value: " + hand.getHandTotal());
                if(bust){
                    System.out.println("You bust.");
                    hand.clear();
                    System.out.println("------------------------------------------------");
                    break;
                }
                System.out.println("------------------------------------------------");
                System.out.println("Dealer shows: " + dealer.getDealer().getHand().getCard(1).toString());
                if(hand.getHandTotal() == 21){
                    activeTurn = false;
                    System.out.println("You have 21.");
                    System.out.println("------------------------------------------------");
                    break;
                }
                System.out.println(name + " what is your move? [H (Hit) / S (Stand) / D (Double down)"  /*+ " / SP (Split)"*/ + "]");
                //input.nextLine();
                while(true){
                    try{
                        move = Blackjack.in.nextLine();
                        move.toUpperCase();
                        if(move.equals("H") || move.equals("S") || move.equals("D") || move.equals("SP")){
                            break;
                        }
                        //throw new Exception("Invalid");
                    }
                    catch(Exception e){
                        System.out.println("Invalid response, try again: ");
                    }
                }
                switch (move){
                    case "S":
                        System.out.println(name + " stands. Turn over.");
                        activeTurn = false;
                        break;
                    case "H":
                        hand.addCard(dec.pull());
                        break;
                    case "D":
                        if(moveNum == 0)bet *= 2;
                        break;
                }
            }
        //}
    }
}
