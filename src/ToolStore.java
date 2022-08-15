public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("");
        System.out.println("Welcome to the tool store!");
        System.out.println(" 1- Weapons ");
        System.out.println(" 2- Armor ");
        System.out.println(" 3- Exit ");
        System.out.print("Please choose one: ");
        int selectCase = Location.input.nextInt();

        while (selectCase < 1 || selectCase > 3 ){
            System.out.print("Invalid choice! Please enter again: ");
            selectCase = input.nextInt();
        }

        switch (selectCase){
            case 1:
            printWeapon();
            buyWeapon();
            break;

            case 2:
            printArmor();
            break;
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("");
        System.out.println("Weapons: ");

        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " < ID: " + w.getId() + " Damage: " + w.getDamage() + " Price: " + w.getPrice() + ">");
        }
        
    }

    public void buyWeapon(){
        System.out.print("Please enter a weapon ID: ");
        int selectWeapon = input.nextInt();
    
            while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length){
                System.out.print("Invalid choice! Please enter again: ");
                selectWeapon = input.nextInt();
            }
    
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeapon);
    
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("");
                    System.out.println("You don't have enough money!");
                }
                else {
                    System.out.println("");
                    System.out.println(selectedWeapon.getName() + " has bought.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Current balance: " + this.getPlayer().getMoney());
                    //System.out.println("Your previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    //System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }

        }

    }

    public void printArmor() {
        System.out.println("Armor: ");

    }



    
}
