package dk.experis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    public String name;
    public int level;
    public HeroAttribute[] levelAttributes;
    public Map<Slot, Item> equipment;
    public List<WeaponType> validWeaponTypes;
    public List<ArmorType> validArmorTypes;



    protected Hero(String name){
        this.name = name;
        this.level = 1;
        this.equipment = new HashMap<>();
        this.validWeaponTypes = new ArrayList<>();
        this.validArmorTypes = new ArrayList<>();
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }
    public void LevelUp(){
        this.levelAttributes[0].addAttribute(this.levelAttributes[1]);
        this.level++;
    }
    public void Equip(Weapon weapon) {
        if (!validWeaponTypes.contains(weapon.type)){
            try {
                throw new InvalidWeaponException("Your Hero cannot equip weapons of type: "+ weapon.type);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (this.level < weapon.requiredLevel){
            try {
                throw  new InvalidWeaponException("To equip this weapon you must be level "+ weapon.requiredLevel + " or more. You are currently level " + this.level);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        this.equipment.put(weapon.slot, weapon);
    }
    public void Equip(Armor armor){
        if (!validArmorTypes.contains(armor.type)){
            try {
                throw new InvalidArmorException("Your Hero can't equip armor of type: " + armor.type);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (this.level < armor.requiredLevel){
            try {
                throw new InvalidArmorException("To equip this armor you must be level " + armor.requiredLevel + " or more. You are currently level " + this.level);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        this.equipment.put(armor.slot, armor);
    }
    public abstract double Damage();
    public HeroAttribute TotalAttributes(){
        HeroAttribute totalAttributes = new HeroAttribute(0,0,0);
        totalAttributes.addAttribute(this.levelAttributes[0]);
        for(Map.Entry<Slot, Item> set : this.equipment.entrySet()){
            if (set.getKey() != Slot.WEAPON && set.getValue() != null){
                totalAttributes.addAttribute(((Armor)set.getValue()).attribute);
            }
        }
        return totalAttributes;
    }
    public void Display(){
        StringBuilder display = new StringBuilder();
        display.append("Name: "+ this.name);
        display.append(" Class: " + this.getClass().getSimpleName());
        display.append(" Level: " + this.level);
        display.append(" Total strength: " + this.TotalAttributes().strength);
        display.append(" Total dexterity: " + this.TotalAttributes().dexterity);
        display.append(" Total intelligence: " + this.TotalAttributes().intelligence);
        display.append(" Damage: " + this.Damage());

        System.out.println(display.toString());



    }
}
