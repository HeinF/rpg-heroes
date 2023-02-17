package dk.experis;

public class Warrior extends Hero{

    protected Warrior(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(5, 2, 1), new HeroAttribute(3, 2, 1)};
        this.validWeaponTypes.add(WeaponType.AXE);
        this.validWeaponTypes.add(WeaponType.HAMMER);
        this.validWeaponTypes.add(WeaponType.SWORD);
        this.validArmorTypes.add(ArmorType.MAIL);
        this.validArmorTypes.add(ArmorType.PLATE);
    }
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
