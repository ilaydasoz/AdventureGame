package locations;
import game.Player;
import obstacles.Snake;

public class Mine extends BattleLoc {

    public Mine (Player player) {
        super(player, "Mine", new Snake(), "item", 5);
    }
    
}
