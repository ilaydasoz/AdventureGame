import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);

    private int damage;
    private int health;
    private int money;
    private String characterName;
    private String name;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Characters: ");
        for(GameChar gameChar : charList){
            System.out.println("ID:" + gameChar.getId() +
            "\t Character: " + gameChar.getName() + 
            "\t Damage: " + gameChar.getDamage() + 
            "\t Health: " + gameChar.getDamage() +
            "\t Money: " + gameChar.getMoney());
        }

        System.out.print("Please enter your character's ID: ");
        int selectChar = input.nextInt();

        switch (selectChar) {
        case 1:
        initPlayer(new Samurai());
        break;

        case 2:
        initPlayer(new Archer());
        break;

        case 3:
        initPlayer(new Knight());
        break;

        default:
        initPlayer(new Samurai());
    }

    /* System.out.println("Character: " + this.getCharacterName() +
    ", Damage: " + this.getDamage() +
    ", Health: " + this.getHealth() +
    ". Money: " + this.getMoney()); */

}

    public void initPlayer(GameChar gameChar){
        this.setCharacterName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo(){
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
        " Armor: " + this.getInventory().getArmor().getName() +
        " Block Capacity: " + getInventory().getArmor().getBlock() +
        " Damage: " + this.getDamage() +
        " Health: " + this.getHealth() +
        " Money: " + this.getMoney());
    }
    
    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        this.money = money;
    }


    public String getCharacterName() {
        return characterName;
    }


    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}
