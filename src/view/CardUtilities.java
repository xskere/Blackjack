package view;

import java.util.ArrayList;
import java.util.Collections;

public class CardUtilities {

    public static ArrayList<String> fillAndMixDeck() {
        ArrayList<String> deck = new ArrayList<>();
        for (int j = 0; j <= 3; j++) {
            for (Integer i = 2; i <= 10; i++) {
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

    public static void giveCards(ArrayList<ArrayList<String>> players, ArrayList<String> deck) {
        for (ArrayList<String> player : players) {
            while (GameUtilities.checkSum(player) <= 16) {
                player.add(deck.remove(deck.size() - 1));
            }
        }
    }

    public static ArrayList<ArrayList<String>> getPlayers(int numberOfPlayers) {
        ArrayList<ArrayList<String>> players = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new ArrayList<String>());
        }
        return players;
    }

    public static void firstTwoCards(ArrayList<ArrayList<String>> players, ArrayList<String> deck) {
        for (ArrayList<String> player : players) {
            player.add(deck.remove(deck.size() - 1));
            player.add(deck.remove(deck.size() - 1));
        }
    }

    public static void giveCardsCroupier(ArrayList<String> croupier, ArrayList<String> deck) {
        while (GameUtilities.checkSum(croupier) <= 16) {
            croupier.add(deck.remove(deck.size() - 1));
        }
    }

}
