package game;
import items.Armor;
import items.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean firewood;
    private boolean water;
    

    public Inventory() {
        this.weapon = new Weapon(-1, "Fist", 0, 0);
        this.armor = new Armor(-1, "Shred", 0, 0);
        this.food = false;
        this.firewood = false;
        this.water = false;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Armor getArmor(){
        return armor;
    }

    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return true;
    }

    public boolean isFirewood() {
        return true;
    }

    public boolean isWater() {
        return true;
    }

    
}
