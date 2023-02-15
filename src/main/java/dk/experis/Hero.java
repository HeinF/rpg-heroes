package dk.experis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    public String name;
    public int level;
    public HeroAttribute[] LevelAttributes;
    public Map<Slot, Item> equipment;
    public List<WeaponType> validWeaponTypes;

    public List<ArmorType> validArmorTypes;



    protected Hero(String name){
        this.name = name;
        this.level = 1;
        this.equipment = new HashMap<>();
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }
    public abstract void LevelUp();
    public abstract String EquipWeapon();
    public abstract String EquipArmor();
    public abstract double Damage();
    public abstract void TotalAttributes();
    public abstract void Display();



}
