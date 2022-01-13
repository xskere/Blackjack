package view;

import java.util.ArrayList;
import java.util.Collections;

public class GameUtilities {
    
    
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
            if(isBlackJack(player1)) winners.add("Player 1 (Black Jack) wins.");
            if(isBlackJack(player2)) winners.add("Player 2 (Black Jack) wins.");
            if(isBlackJack(player3)) winners.add("Player 3 (Black Jack) wins.");
            
            if(sumPlayer1 <= 21 && (sumCroupier > 21 || sumCroupier < sumPlayer1) && !isBlackJack(player1)) winners.add("Player 1 wins.");
            if(sumPlayer2 <= 21 && (sumCroupier > 21 || sumCroupier < sumPlayer2) && !isBlackJack(player2)) winners.add("Player 2 wins.");
            if(sumPlayer3 <= 21 && (sumCroupier > 21 || sumCroupier < sumPlayer3) && !isBlackJack(player3)) winners.add("Player 3 wins.");
        } 
            if(winners.isEmpty()) winners.add("House wins.");
            return winners;
    }


    
    
        
        
        
        
}


