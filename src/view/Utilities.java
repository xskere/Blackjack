package view;

import java.util.ArrayList;
import java.util.Collections;

public class Utilities {
    
    public static ArrayList<String> fillAndMixDeck(){
        ArrayList<String> deck = new ArrayList<>();
        
        for(int j = 0; j<=3; j++){
            
            for(Integer i = 2; i <= 10; i++){
                deck.add(i.toString());
            }
            
            deck.add("A");
            deck.add("J");
            deck.add("Q");
            deck.add("K");
        }
        Collections.shuffle(deck);
        return deck;
        
    }
    
    public static ArrayList<ArrayList<String>> getPlayers(int numberOfPlayers){
        ArrayList<ArrayList<String>> players = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < numberOfPlayers; i++){
            players.add(new ArrayList<String>());
            
            
        }
        
        return players;
    }
    
    public static void firstTwoCards(ArrayList<ArrayList<String>> players, ArrayList<String> deck){
        for (ArrayList<String> player : players) {
            player.add(deck.remove(deck.size()-1));
            player.add(deck.remove(deck.size()-1)); 
        }
        
        
    }
    
    public static void giveCards (ArrayList<ArrayList<String>> players, ArrayList<String> deck){
        for (ArrayList<String> player : players) {
            while(Utilities.checkSum(player) <= 16){ 
                player.add(deck.remove(deck.size()-1));
            }
        }
    }
    
    public static void giveCardsCroupier (ArrayList<String> croupier, ArrayList<String> deck){
        while(Utilities.checkSum(croupier) <= 16){ 
                croupier.add(deck.remove(deck.size()-1));
        }
    }
    
    public static int checkSum(ArrayList<String> cards) {
        ArrayList<String> player = new ArrayList<String>(cards);
        int total=0;
        int ocurrences = Collections.frequency(player, "A");
        ArrayList<Integer> posibilities = new ArrayList<Integer>();
        if(ocurrences != 0){
            player.removeAll(Collections.singleton("A"));
            for(int i = 0; i <= ocurrences * 2; i++){
                int sum=0;
                for (int j = 1; j <= ocurrences; j++) {
                    if(j >= i){
                        sum+=11;
                    }else{
                        sum+=1;
                    }
                }
                posibilities.add(sum);
            }
            
        }else{
            posibilities.add(0);
        }

        
        for (String string : player) {
            if(string.equals("J") || string.equals("Q") || string.equals("K")){
                for (int i = 0; i < posibilities.size(); i++) {
                    posibilities.set(i, posibilities.get(i)+10);
                }
            }else{
                for (int i = 0; i < posibilities.size(); i++) {
                    posibilities.set(i, posibilities.get(i)+Integer.parseInt(string));
                }
            }

        }
        
        total = posibilities.get(posibilities.indexOf(Collections.min(posibilities)));
        for (Integer posibility : posibilities) {
            if(total < posibility && posibility <= 21){
                total = posibility;
            }
        }
        return total;
        
    }
    
    private static boolean isBlackJack(ArrayList<String> cards){
        if(cards.size()==2 && checkSum(cards) == 21) return true;
        return false;
    }
    
    public static ArrayList<String> getWinners(ArrayList<String> player1,
                        ArrayList<String> player2, ArrayList<String> player3,
                        ArrayList<String> croupier, ArrayList<String> deck){
        
        
        ArrayList<String> winners = new ArrayList<String>();
        
        if  (player1.size() + player2.size() +  player3.size() + 
                croupier.size() + deck.size() != 52){
            winners.add("Hubo un error de reparto o alguien hizo trampas");
            return winners;
        }
        
        boolean croupierBlackJack = isBlackJack(croupier);
        int sumCroupier = checkSum(croupier);
        int sumPlayer1 = checkSum(player1);
        int sumPlayer2 = checkSum(player2);
        int sumPlayer3 = checkSum(player3);
                
        
        if(!croupierBlackJack){
            if(isBlackJack(player1)) winners.add("Player 1 (Black Jack)");
            if(isBlackJack(player2)) winners.add("Player 2 (Black Jack)");
            if(isBlackJack(player3)) winners.add("Player 3 (Black Jack)");
            
            if(sumPlayer1 <= 21 && sumCroupier > 21 && !isBlackJack(player1)) winners.add("Player 1");
            if(sumPlayer2 <= 21 && sumCroupier > 21 && !isBlackJack(player2)) winners.add("Player 2");
            if(sumPlayer3 <= 21 && sumCroupier > 21 && !isBlackJack(player3)) winners.add("Player 3");
        } 
            if(winners.isEmpty()) winners.add("House ");
            return winners;
    }


    
    
        
        
        
        
}


