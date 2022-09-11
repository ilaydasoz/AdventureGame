package locations;
import game.Player;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are at the safe house.");
        System.err.println("Health is full now!");
        this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        return true;
    }
    
}
