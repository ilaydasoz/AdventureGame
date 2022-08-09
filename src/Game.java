import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    
    public void start(){

        System.out.println("Welcome to the Adventure Game created by ISY!\n");
        System.out.print("Please enter your name: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hey," + player.getName() + " welcome to the game!\n");        
        player.selectChar();



    }
}

