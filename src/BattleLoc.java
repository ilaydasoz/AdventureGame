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
            //battle 
        }
        return true;
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
