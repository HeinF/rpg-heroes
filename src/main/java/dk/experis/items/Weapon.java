package dk.experis.items;

import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;

public class Weapon extends Item {

    private WeaponType type;
    private double weaponDamage;
    // Subclass constructor
    public Weapon(String name, int requiredLevel, WeaponType type, double damage) {
        super(name, requiredLevel);
        this.type = type;
        this.weaponDamage = damage;
        this.slot = Slot.WEAPON;
    }
    // Getters
    public WeaponType getType() {
        return type;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }
}
