package Card;

public class dealer {
    public static int[] dealerHand(int card[][])
    {
        int[] playerHand = new int[2];
        playerHand[0] = card[0][0];
        playerHand[1] = card[0][1];

        return playerHand;
    }
}
