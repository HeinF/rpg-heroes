package dk.experis;

public class Ranger extends Hero{

    protected  Ranger(String name) {
        super(name);

        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(1, 7, 1), new HeroAttribute(1, 5, 1)};
        this.validWeaponTypes.add(WeaponType.BOW);
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
