import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle){
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are at the " + this.getName() + " now. Be aware of " + obsNumber + " " + this.getObstacle().getName() + " !");
        System.out.println("<F>IGHT! or <R>UN!");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if ( selectCase.equals("F")) {
            if (combat(obsNumber)) {
                System.out.println("All obstacles are killed.You win!");
                return true;
            }
        }

        if (this.getPlayer().getHealth() < 0) {
            System.out.println("You died...");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i=1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth()); //set every new obstacle's health to default
            playerStatus();
            obstacleStatus(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<H>IT OR <R>UN!");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H") ){
                    System.out.println();
                    System.out.println("YOU HIT 'EM!");
                    obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " HIT YOU!");
                        int obstacleDamage = this.getObstacle().getHealth() - this.getPlayer().getTotalDamage();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
            
                    }                   

                }

                else {
                    return false;
                }

            }

            if ( this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You killed " + this.getObstacle().getName() + "!");
                System.out.println("You won: " + this.getObstacle().getAward() + "$");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your balance: " + this.getPlayer().getMoney() + "$");
                System.out.println();
            }
        }
        return false;
    }

    public void playerStatus() {
        System.out.println("Player Status: ");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Blocking: " + this.getPlayer().getInventory().getArmor().getBlock()); 
        System.out.println();  

    }

    public void obstacleStatus(int i) {
        System.out.println(this.getObstacle().getName() + " number " + i + "'s Status: ");
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public void afterHit() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() +"'s health: " + this.getObstacle().getHealth());
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
        
    }

    public Obstacle getObstacle(){
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle){
        this.obstacle = obstacle;
    }
    
    public String getAward() {
        return award;
    }
    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    
}
