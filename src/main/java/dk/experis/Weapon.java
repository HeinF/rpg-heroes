package dk.experis;

public class Weapon extends Item{



    private WeaponType type;
    private double weaponDamage;
    public Weapon(String name, int requiredLevel, WeaponType type, double damage) {
        super(name, requiredLevel);
        this.type = type;
        this.weaponDamage = damage;
        this.slot = Slot.WEAPON;
    }

    public WeaponType getType() {
        return type;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }
}
