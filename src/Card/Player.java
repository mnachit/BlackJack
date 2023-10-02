package Card;

public class Player {

    private String name;

    private int pot;

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

    public void loss(int num)
    {
        pot -= num;
    }

    public void blackjack(int num)
    {

    }


}
