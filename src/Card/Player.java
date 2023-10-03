package Card;

public class Player {

    private String name;

    private int pot;

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int pot() { return pot;};

    public String getName() {
        return name;
    }

    public Player(String Pname)
    {
        this.name = Pname;
        this.pot = 100;
    }

    public void win(int num)
    {
        pot += num;
    }

    public static int[] playerHand(int card[][])
    {
        int[] playerHand = new int[2];
        playerHand[0] = card[0][0];
        playerHand[1] = card[0][1];

        return playerHand;
    }

    public void loss(int num)
    {
        pot -= num;
    }

    public void blackjack(int num)
    {

    }


}
