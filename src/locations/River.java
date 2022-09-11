package locations;
import game.Player;
import obstacles.Bear;

public class River extends BattleLoc {

    public River(Player player) {
        super(player, "River", new Bear(), "water", 3);
        
    }

   
    
}
