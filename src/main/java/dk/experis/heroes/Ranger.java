package dk.experis.heroes;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.items.Weapon;

public class Ranger extends Hero {

    // Subclass constructor.
    // Sets name via. super, then adds base and level gain attributes and valid weapon and armor types.
    // All are specific to the Ranger subclass
    public  Ranger(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(1, 7, 1), new HeroAttribute(1, 5, 1)};
        this.validWeaponTypes.add(WeaponType.BOW);
        this.validArmorTypes.add(ArmorType.LEATHER);
        this.validArmorTypes.add(ArmorType.MAIL);
    }
    // Calculate damage with or without a weapon equipped.
    // For Rangers dexterity is a damaging attribute that adds damage
    @Override
    public double damage() {
        double damage;
        if(this.equipment.get(Slot.WEAPON) != null){
            damage = ((Weapon)this.equipment.get(Slot.WEAPON)).getWeaponDamage()* (1 + (double)this.totalAttributes().dexterity / 100);
        } else {
            damage = 1 + (double)this.totalAttributes().dexterity / 100;
        }
        return Math.round(damage * 100.0) / 100.0;
    }
}
