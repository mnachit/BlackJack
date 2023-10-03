package Card;

import java.util.Scanner;

import static Card.Card_management.*;

public class Game {

    public static void main(String[] args) {

        System.out.println(""
                + "\n"
                + "          ██     ██ ███████ ██       ██████  ██████  ███    ███ ███████ \n"
                + "          ██     ██ ██      ██      ██      ██    ██ ████  ████ ██      \n"
                + "          ██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████   \n"
                + "          ██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██      \n"
                + "           ███ ███  ███████ ███████  ██████  ██████  ██      ██ ███████ \n"
                + "                                                                        \n"
                + "                                                                        \n"
                + "          ");
        System.out.println("Don't forget, This game is Haram");
        System.out.println("Are you sure you want to play?\n1) Yes\n2) No");
        System.out.printf("-> ");
        Scanner scanner = new Scanner(System.in);
        int check = scanner.nextInt();
        boolean leave = false;
        switch (check)
        {
            case 1:
                System.out.print("Your name : -> ");
                String nameP = scanner.next();
                Player player = new Player(nameP);
                scanner.nextLine();
                int[][] deck = createDeckOfCards(1, 1);
                //
                int[][] shuffledDeck = melanger_jeu_cartes(deck);
                int index = 24;
                int sum = 0;
                int[][][] result = piocher_n_cartes(shuffledDeck, index);
                int[][] card1 = result[0];
                int price = 0;
                // Create Object in class Player
                System.out.println("Hey " + player.getName() + " So Your money is : " + player.pot() + "$\n");
                while (leave == false) {
                    System.out.println("Your Sold is : "+player.getPot()+"$ How do you want to bet?\n");
                    System.out.printf("-> ");
                    price = scanner.nextInt();
                    player.setPot(player.getPot() - price);
                    while (price < 01)
                    {
                        System.out.println("No");
                    }
                    if (price > player.pot()) {
                        System.err.println("\nPrice not found");
                        System.exit(-1);
                        break;
                    }

//                    System.out.println(card1.length);
                    if(card1.length == 0 || card1.length < 0)
                    {
                        System.err.println("Length is null");
                        System.exit(-1);
                    }
                    int[][] shuffledCards = new int[card1.length][2];
                    boolean checkBo = false;
                    int indexx = 0;
                    System.out.print("Your cards are: ");
                    while (!checkBo) {
                        int[][][] drawnCard = extraire_ieme_carte(card1, 0);
                        shuffledCards[0] = drawnCard[0][0];
                        card1 = drawnCard[1];
                        int res[] = Player.playerHand(shuffledCards);

                        System.out.print("["+res[0]+","+res[1]+"]");
                        if (res[0] == 1) {
                            res[0] = 11;
                        }
                        else if (res[0] == 11 || res[0] == 12 || res[0] == 13) {
                            res[0] = 10;
                        }
                        sum += res[0];
                        indexx++;

                        //                    break;
                        if (indexx == 2)
                            checkBo = true;
                        else if (indexx != 2) {
                            System.out.print(" and ");
                        }
                    }

                    System.out.println("\nYour total is " + sum);
                    if (sum > 21) {
                        System.out.println("Your pot is now :"+player.getPot());
                        System.out.print("\nPlay another hand? (Y/n) ");
                        Scanner end = new Scanner(System.in);
                        String yesNo = end.nextLine();
                        System.out.print("-> ");
                        if(yesNo.equalsIgnoreCase("n"))
                        {
                            leave = true;
                            System.out.println();
                            System.out.println("You have left the table with $"+player.pot());
                        }
                        System.out.println();
                    } else if (sum == 21) {
                        player.setPot(player.getPot() + price + price);
                        System.out.println("\n");
                    } else {
                        String choice = "";
                        System.out.println();
                        System.out.print("Hit or Stay: ");
                        Scanner hit = new Scanner(System.in);
                        choice = hit.nextLine();
                        System.out.println();
                        // make sure you can only hit or stay
                        while (!(choice.equalsIgnoreCase("stay") || choice.equalsIgnoreCase("hit"))) {
                            System.out.print("Please enter HIT or STAY: ");
                            choice = hit.nextLine();
                        }
                        while (choice.equalsIgnoreCase("hit")) {
//                            System.out.println(card1.length);
                            System.out.print("\nYour next card is: ");
                            if(card1.length == 0 || card1.length < 0)
                            {
                                System.err.println("Length is null");
                                System.exit(-1);
                                break;
                            }
                            int[][][] drawnCard = extraire_ieme_carte(card1, 0);
                            shuffledCards[0] = drawnCard[0][0];
                            card1 = drawnCard[1];
                            int res[] = Player.playerHand(shuffledCards);

                            System.out.print("["+res[0]+","+res[1]+"]");
                            if (res[0] == 1) {
                                if(res[0] <= 10)
                                    res[0] = 11;
                                else if (res[0] > 10)
                                    res[0] = 1;
                            }
                            else if (res[0] == 10 || res[0] == 11 || res[0] == 12 || res[0] == 13 ) {
                                res[0] = 10;
                            }
                            sum += res[0];
                            System.out.println("\nYour total is " + sum);
                            if (sum > 21) {
                                System.out.print("\nYou bust!\n" +
                                        "Your pot is now $" + player.getPot() + "\n");
                                break;
                            } else if (sum == 21) {
                                player.setPot(player.getPot() + price + price);
                                break;
                            }
                            else {
                                System.out.print("Hit or Stay: ");
                                choice = hit.nextLine();
                                while (!(choice.equalsIgnoreCase("stay") || choice.equalsIgnoreCase("hit"))) {
                                    System.out.print("Please enter HIT or STAY: ");
                                    choice = hit.nextLine();
                                    System.out.println();
                                }
                            }
                        }

                        if (choice.equalsIgnoreCase("stay")) {
                            int sum1 = 0;
                            int index2 = 0;
                            int[][] shuffledCards1 = new int[card1.length][2];
                            System.out.println(card1.length);
                            boolean checkBo2 = false;
                            boolean checkBo3 = false;
                            System.out.print("The dealers' cards are: ");
                            while (!checkBo2) {
                                int[][][] drawnCard1 = extraire_ieme_carte(card1, 0);
                                shuffledCards1[0] = drawnCard1[0][0];
                                card1 = drawnCard1[1];
                                int res1[] = Player.playerHand(shuffledCards1);

                                System.out.print("[" + res1[0] + "," + res1[1] + "]");
                                if (res1[0] == 1) {
                                    res1[0] = 11;
                                }
                                if (res1[0] == 11 || res1[0] == 12 || res1[0] == 13 ) {
                                    res1[0] = 10;
                                }
                                sum1 += res1[0];
                                index2++;

                                if (index2 == 2)
                                    checkBo2 = true;
                                else if (index2 != 2) {
                                    System.out.print(" and ");
                                }
                            }
                            System.out.println("\nThe dealers' total is " + sum1);

                            if (sum1 > 21)
                            {
                                System.out.println(sum1 + "Dealer loses!");
                                player.setPot(player.getPot() + price + price);
                            }
                            else if (sum1 == 21)
                            {
                                System.out.println(sum1 + "Dealer Wins!");
                            }
                            else
                            {
                                if (sum < sum1)
                                    System.out.println(sum1 + " Dealer Wins!");
                                else {
                                    while (!checkBo3)
                                    {
                                        System.out.print("\nThe dealers' next card is: ");
                                        if(card1.length == 0 || card1.length < 0)
                                        {
                                            System.err.println("Length is null");
                                            System.exit(-1);
                                            break;
                                        }
                                        int[][][] drawnCard1 = extraire_ieme_carte(card1, 0);
                                        shuffledCards1[0] = drawnCard1[0][0];
                                        card1 = drawnCard1[1];
                                        int res1[] = Player.playerHand(shuffledCards1);

                                        System.out.print("["+res1[0]+","+res1[1]+"]");
                                        if (res1[0] == 1) {
                                            res1[0] = 11;
                                        }
                                        if (res1[0] == 11 || res1[0] == 12 || res1[0] == 13 ) {
                                            res1[0] = 10;
                                        }
                                        sum1 += res1[0];
                                        System.out.println("\nThe dealers' total is " + sum1);

                                        if (sum1 > 21)
                                        {
                                            System.out.println(sum1 + " Dealer loses!");
                                            player.setPot(player.getPot() + price + price);
                                            checkBo3 = true;
                                            break;
                                        }
                                        else if (sum1 == 21)
                                        {
                                            System.out.println(sum1 + "Dealer Wins!");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        choice = "";
                    }

                    if(player.getPot() == 0)
                        leave = true;
                    // get input to keep playing
                    else
                    {
                        System.out.println("Your pot is now :"+player.getPot());
                        System.out.print("\nPlay another hand? (Y/n) ");
                        Scanner end = new Scanner(System.in);
                        String yesNo = end.nextLine();
                        System.out.print("-> ");
                        if(yesNo.equalsIgnoreCase("n"))
                        {
                            leave = true;
                            System.out.println();
                            System.out.println("You have left the table with $"+player.pot());
                        }
                        System.out.println();
                    }
                }

                break;
            case 2:
                System.out.println("Well done");
                break;
            default:
//                System.err.println("Error");
//                System.exit(-1);
        }




    }

}