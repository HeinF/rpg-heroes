package dk.experis;

public class Weapon extends Item{

    public WeaponType type;
    public double weaponDamage;
    public Weapon(String name, int requiredLevel, Slot slot, WeaponType type, double damage) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.weaponDamage = damage;

    }
}
