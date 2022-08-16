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

        Location location = null;

        while (true){
            player.printInfo();
            System.out.println("");
            System.out.println("Areas: ");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("Press 0 to exit game");
            System.out.print("Please select the area you want to go: ");
            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 0:
                location = null; 
                break; 

                case 1:
                location = new SafeHouse(player);
                break;

                case 2:
                location = new ToolStore(player);
                break;

                default:
                location = new SafeHouse(player);
            }

            if (location == null){
                System.out.println("Game is over!");
                break;
            }

            if (!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }

        }



    }
}

