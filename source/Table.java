package source;


public class Table {
    
    Player[] players = new Player[4];
    int playerCount;
    public Table(){
            System.out.print("Enter the number of players: ");
            playerCount = Blackjack.in.nextInt();
            Blackjack.in.nextLine();
            String pName;

            for(int i = 0; i < playerCount; i++){
                System.out.print("Enter player (" + (i+1) + ") name: ");
                pName = Blackjack.in.nextLine();
                players[i] = new Player(pName, i+1);
            }
            System.out.println("------------------------------------------------");

    }
    public Player[] getPlayers(){
        return players;
    }
    public int getPlayerCount(){
        return playerCount;
    }
}
