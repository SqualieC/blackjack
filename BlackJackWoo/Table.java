package BlackJackWoo;
//import java.util.Scanner;


public class Table {
    
    Player[] players = new Player[4];
    int playerCount;
    public Table(){
        //try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of players: ");
            playerCount = Blackjack.in.nextInt();
            Blackjack.in.nextLine();
            String pName;

            for(int i = 0; i < playerCount; i++){
                System.out.print("Enter player (" + (i+1) + ") name: ");
                pName = Blackjack.in.nextLine();
                players[i] = new Player(pName, i+1);
                //System.out.println("Player (" + (i+1) + ") is named " + players[i].getName());
            }
            System.out.println("------------------------------------------------");
            //Blackjack.in.close();
        //}

    }
    public Player[] getPlayers(){
        return players;
    }
    public int getPlayerCount(){
        return playerCount;
    }
}
