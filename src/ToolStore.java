public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("");
        System.out.println("Welcome to the tool store!");
        boolean showMenu = true;
        while(showMenu){
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
            buyArmor();
            break;

            case 3:
            System.out.println("");
            System.out.println("Goodbye, " + this.getPlayer().getName() + "!");
            showMenu = false;
            break;
        }

    }

    return true;
}



    public void printWeapon() {
        System.out.println("");
        System.out.println("Weapons: ");

        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " < ID: " + w.getId() + " Damage: " + w.getDamage() + " Price: " + w.getPrice() + ">");
        }
        
        System.out.println("0 - Exit");

    }

    public void buyWeapon(){
        System.out.print("Please enter a weapon ID: ");
        int selectWeaponID = input.nextInt();
    
            while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
                System.out.print("Invalid choice! Please enter again: ");
                selectWeaponID = input.nextInt();
            }

            if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);
    
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
}

    public void printArmor() {
        System.out.println("Armor: ");
        for (Armor a : Armor.armors()){
            System.out.println(a.getName() + " < ID: " + a.getId() + " Block Capacity: " + a.getBlock() + " Price: " + a.getPrice() + ">");
        }

        System.out.println(" 0 - Exit");

    }

    public void buyArmor(){
        System.out.print("Please enter an armor ID: ");
        int selectArmorID = input.nextInt();
    
            while (selectArmorID < 0 || selectArmorID > Armor.armors().length){
                System.out.print("Invalid choice! Please enter again: ");
                selectArmorID = input.nextInt();
            }

            if (selectArmorID != 0){
    
            Armor selectedArmor = Armor.getArmorByID(selectArmorID);
    
            if (selectedArmor!= null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("");
                    System.out.println("You don't have enough money!");
                }
                else {
                    System.out.println("");
                    System.out.println(selectedArmor.getName() + " has bought.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Current balance: " + this.getPlayer().getMoney());
                    //System.out.println("Your previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    //System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }

        }

    }
}



    
}
