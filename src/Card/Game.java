package Card;

import java.util.Scanner;

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

        switch (check)
        {
            case 1:
                System.out.print("Your name : -> ");
                String nameP = scanner.next();
                Player player = new Player(nameP);
                scanner.nextLine();

                // Create Object in class Player
                System.out.println("Hey " + player.getName() + " So Your money is : " + player.pot() + "$\n");

                System.out.println("How do you want to bet?\n");
                System.out.printf("-> ");
                int price = scanner.nextInt();

                if (price >= player.pot())
                {
                    System.err.println("\nPrice not found");
                    System.exit(-1);
                    break;
                }

            case 2:
                System.out.println("Well done");
                break;
            default:
//                System.err.println("Error");
//                System.exit(-1);
        }




    }

}