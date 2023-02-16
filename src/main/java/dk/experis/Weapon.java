package dk.experis;

public class Weapon extends Item{

    public WeaponType type;
    public double weaponDamage;
    public Weapon(String name, int requiredLevel, WeaponType type, double damage) {
        super(name, requiredLevel);
        this.type = type;
        this.weaponDamage = damage;
        this.slot = Slot.WEAPON;

    }
}
