package dk.experis.heroes;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.items.Weapon;

public class Mage extends Hero {
    // Subclass constructor.
    // Sets name via. super, then adds base and level gain attributes and valid weapon and armor types.
    // All are specific to the Mage subclass
    public Mage(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(1,1,8), new HeroAttribute(1,1,5)};
        this.validWeaponTypes.add(WeaponType.STAFF);
        this.validWeaponTypes.add(WeaponType.WAND);
        this.validArmorTypes.add(ArmorType.CLOTH);
    }
    // Calculate damage with or without a weapon equipped.
    // For Mages intelligence is a damaging attribute that adds damage
    @Override
    public double damage() {
        double damage;
        if(this.equipment.get(Slot.WEAPON) != null){
            damage = ((Weapon)this.equipment.get(Slot.WEAPON)).getWeaponDamage()* (1 + (double)this.totalAttributes().intelligence / 100);
        } else {
            damage = 1 + (double)this.totalAttributes().intelligence / 100;
        }
        // Round to avoid comparison problems
        return Math.round(damage * 100.0) / 100.0;
    }

}
