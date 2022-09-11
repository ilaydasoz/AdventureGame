package locations;
import game.Player;
import obstacles.Zombie;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "food", 3);
    }
       
}
