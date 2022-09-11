package game;
import java.util.Scanner;

import locations.Cave;
import locations.Forest;
import locations.Location;
import locations.Mine;
import locations.River;
import locations.SafeHouse;
import locations.ToolStore;

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
            System.out.println("3 - Cave");
            System.out.println("4 - Forest");
            System.out.println("5 - River");
            System.out.println("6 - Mine");
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

                case 3:
                location = new Cave(player);
                break;

                case 4:
                location = new Forest(player);
                break;

                case 5:
                location = new River(player);
                break;

                case 6:
                location = new Mine(player);
                break;

                default:
                System.out.println("Invalid choice!");
                break;
            }

            if(location == null){
                System.out.println("See you.. for now!");
                break;
            }

            if (!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }

           // if (player.getInventory().isFirewood() && player.getInventory().isWater() && player.getInventory().isFood()) {
               // System.out.println("All awards are collected. YOU WIN!");
              // break;
           // }
        }
    }
}

