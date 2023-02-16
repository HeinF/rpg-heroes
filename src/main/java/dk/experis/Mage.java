package dk.experis;

public class Mage extends Hero {
    protected Mage(String name) {
        super(name);

        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(1,1,8), new HeroAttribute(1,1,5)};
        this.validWeaponTypes.add(WeaponType.STAFF);
        this.validWeaponTypes.add(WeaponType.WAND);
        this.validArmorTypes.add(ArmorType.CLOTH);
    }

    @Override
    public double damage() {
        double damage;
        if(this.equipment.get(Slot.WEAPON) != null){
            damage = ((Weapon)this.equipment.get(Slot.WEAPON)).getWeaponDamage()* (1 + (double)this.totalAttributes().intelligence / 100);
        } else {
            damage = 1 + (double)this.totalAttributes().intelligence / 100;
        }
        return damage;
    }

}
