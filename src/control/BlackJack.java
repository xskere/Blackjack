package control;

import java.util.ArrayList;
import view.CardUtilities;
import view.GameUtilities;




public class BlackJack {
    
    
    

    public static void main(String[] args) {
        ArrayList<String> deck;
        ArrayList<String> winners;
        ArrayList<ArrayList<String>> players;
        ArrayList<String> croupier = new ArrayList<String>();
        
        deck = CardUtilities.fillAndMixDeck();
        players = CardUtilities.getPlayers(3);
        CardUtilities.firstTwoCards(players, deck);
        CardUtilities.giveCards(players, deck);
        CardUtilities.giveCardsCroupier(croupier, deck);
        
        System.out.println("Final results: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Player "+ (i+1)+": " + players.get(i) + " (" 
                                + GameUtilities.checkSum(players.get(i))+ ")");
        }
        
        System.out.println("Croupier :" + croupier + " (" 
                                + GameUtilities.checkSum(croupier)+ ")");
        
        winners = GameUtilities.getWinners(players.get(0), players.get(1), 
                                        players.get(2), croupier, deck);
                                        
        for (String winner : winners) {
            System.out.println(winner +" wins.");
        }

    }

}
