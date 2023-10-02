package Card;

import java.util.Arrays;
import java.util.Random;

public class Card_management {

    public static int[][] createDeckOfCards(int startRank, int startSuit){
        int NUM_SUITS = 4, NUM_RANKS = 13;
        int size = (13 - startRank + 1) + (4 - startSuit) * 13;
        int[][] cards = new int[size][2];
        int cardIndex = 0;

        for(int suit = startSuit; suit <= NUM_SUITS; suit++){
            for(int rank = startRank; rank <= NUM_RANKS; rank++){
                cards[cardIndex][0] = rank;
                cards[cardIndex][1] = suit;
                cardIndex++;
            }
            startRank = 1;
        }
        return cards;
    }
    public static int[][][] extraire_ieme_carte(int[][] deck, int index) {
        int[][] extraire_deck = new int[deck.length - 1][2];
        int[][] card = new int[1][2];
        int[][][] res = new int[2][][];

        int extraireIndex = 0;
        for (int i = 0; i < deck.length; i++) {
            if (i != index) {
                extraire_deck[extraireIndex][0] = deck[i][0];
                extraire_deck[extraireIndex][1] = deck[i][1];
                extraireIndex++;
            } else {
                card[0][0] = deck[i][0];
                card[0][1] = deck[i][1];
            }
        }

        res[0] = card;
        res[1] = extraire_deck;
        return res;
    }

    public static int tirer_une_carte(int[][] deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.length);

        return randomNumber;

    }
    public static int[][] melanger_jeu_cartes(int[][] card) {
        int num = card.length;
        int[][] shuffledCards = new int[num][2];

        for (int i = 0; i < num; i++) {
            int randomNumber = tirer_une_carte(card);
            int[][][] drawnCard = extraire_ieme_carte(card, randomNumber);
            shuffledCards[i] = drawnCard[0][0];
            card = drawnCard[1];
        }

        return shuffledCards;
    }

    public static int[][][] piocher_n_cartes(int[][] card, int index)
    {
        int[][] card1 = new int[index + 1][2];
        int[][] card2 = new int[card.length - index - 1][2];
        int[][][] res = new int[2][][];;

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < card.length; i++) {
            if (i <= index)
            {
                card1[index1][0] = card[i][0];
                card1[index1][1] = card[i][1];
                index1++;
            }
            else
            {
                card2[index2][0] = card[i][0];
                card2[index2][1] = card[i][1];
                index2++;
            }
        }
        res[0] = card1;
        res[1] = card2;

        return res;
    }

    public static int[][] defausser_cartes(int[][] card1, int[][] card2)
    {
        int[][] card = new int[card1.length + card2.length][2];
        int index = 0;
        int size = card1.length + card2.length;
        for (int i = 0; i < card1.length; i++){
                card[index][0] = card1[i][0];
                card[index][1] = card1[i][1];
                index++;
        }

        for (int j = 0; j < card2.length; j++) {
            card[index][0] = card2[j][0];
            card[index][1] = card2[j][1];
            index++;
        }

        return card;
    }
//    public static void main(String[] args) {
//        int[][] deck = createDeckOfCards(1,1);
//
//        int[][] shuffledDeck = melanger_jeu_cartes(deck);
//        int[][][] s = piocher_n_cartes(shuffledDeck,15);
//        System.out.println("Shuffled Deck:");
//        for (int[] card : shuffledDeck) {
//            System.out.println(Arrays.toString(card));
//        }
//    }

    public static void main(String[] args) {
        int[][] card1 = {
                {1, 1},
                {1, 2}
        };

        int[][] card2 = {
                {3, 4},
                {4, 3}
        };

        int[][] result = defausser_cartes(card1, card2);

        System.out.println("Merged Cards:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("(" + result[i][0] + ", " + result[i][1] + ")");
        }
    }

//    public static void main(String[] args) {
//        int[][] cards = {
//                {13, 4},
//                {5, 3},
//                {1, 1},
//                {6, 3}
//        };
//        int index = 0;
//
//        int[][][] result = piocher_n_cartes(cards, index);
//
//        int[][] card1 = result[0];
//        int[][] card2 = result[1];
//
//        System.out.println("Card 1:");
//        for (int i = 0; i < card1.length; i++) {
//            System.out.println("(" + card1[i][0] + ", " + card1[i][1] + ")");
//        }
//
//        System.out.println("Card 2:");
//        for (int i = 0; i < card2.length; i++) {
//            System.out.println("(" + card2[i][0] + ", " + card2[i][1] + ")");
//        }
//    }
}