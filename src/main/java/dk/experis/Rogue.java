package dk.experis;

public class Rogue extends Hero{

    protected Rogue(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(2, 6, 1), new HeroAttribute(1, 4, 1)};
        this.validWeaponTypes.add(WeaponType.DAGGER);
        this.validWeaponTypes.add(WeaponType.SWORD);
        this.validArmorTypes.add(ArmorType.LEATHER);
        this.validArmorTypes.add(ArmorType.MAIL);
    }
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
