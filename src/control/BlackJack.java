package control;

import java.util.ArrayList;
import view.Utilities;




public class BlackJack {
    
    
    

    public static void main(String[] args) {
        ArrayList<String> deck;
        ArrayList<String> winners;
        ArrayList<ArrayList<String>> players;
        ArrayList<String> croupier = new ArrayList<String>();
        
        deck = Utilities.fillAndMixDeck();
        players = Utilities.getPlayers(3);
        Utilities.firstTwoCards(players, deck);
        Utilities.giveCards(players, deck);
        Utilities.giveCardsCroupier(croupier, deck);
        
        System.out.println("Final results: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Player "+ (i+1)+": " + players.get(i) + " (" 
                                + Utilities.checkSum(players.get(i))+ ")");
        }
        
        System.out.println("Croupier :" + croupier + " (" 
                                + Utilities.checkSum(croupier)+ ")");
        
        winners = Utilities.getWinners(players.get(0), players.get(1), 
                                        players.get(2), croupier, deck);
                                        
        for (String winner : winners) {
            System.out.println(winner +" wins.");
        }

    }

}
