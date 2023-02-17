package dk.experis.heroes;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.items.Weapon;

public class Warrior extends Hero {

    // Subclass constructor.
    // Sets name via. super, then adds base and level gain attributes and valid weapon and armor types.
    // All are specific to the Warrior subclass
    public Warrior(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(5, 2, 1), new HeroAttribute(3, 2, 1)};
        this.validWeaponTypes.add(WeaponType.AXE);
        this.validWeaponTypes.add(WeaponType.HAMMER);
        this.validWeaponTypes.add(WeaponType.SWORD);
        this.validArmorTypes.add(ArmorType.MAIL);
        this.validArmorTypes.add(ArmorType.PLATE);
    }
    // Calculate damage with or without a weapon equipped.
    // For Warriors strength is a damaging attribute that adds damage
    @Override
    public double damage() {
        double damage;
        if(this.equipment.get(Slot.WEAPON) != null){
            damage = ((Weapon)this.equipment.get(Slot.WEAPON)).getWeaponDamage()* (1 + (double)this.totalAttributes().strength / 100);
        } else {
            damage = 1 + (double)this.totalAttributes().strength / 100;
        }
        return Math.round(damage * 100.0) / 100.0;
    }
}
