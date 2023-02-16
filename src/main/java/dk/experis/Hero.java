package dk.experis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {



    private String name;
    protected int level;
    protected HeroAttribute[] levelAttributes;
    protected Map<Slot, Item> equipment;
    protected List<WeaponType> validWeaponTypes;
    protected List<ArmorType> validArmorTypes;



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
    public void levelUp(){
        this.levelAttributes[0].addAttribute(this.levelAttributes[1]);
        this.level++;
    }
    public void equip(Weapon weapon) {
        if (!validWeaponTypes.contains(weapon.getType())){
            try {
                throw new InvalidWeaponException("Your Hero cannot equip weapons of type: "+ weapon.getType());
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (this.level < weapon.getRequiredLevel()){
            try {
                throw  new InvalidWeaponException("To equip this weapon you must be level "+ weapon.getRequiredLevel() + " or more. You are currently level " + this.level);
            } catch (InvalidWeaponException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        this.equipment.put(weapon.slot, weapon);
    }
    public void equip(Armor armor){
        if (!validArmorTypes.contains(armor.getType())){
            try {
                throw new InvalidArmorException("Your Hero can't equip armor of type: " + armor.getType());
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (this.level < armor.getRequiredLevel()){
            try {
                throw new InvalidArmorException("To equip this armor you must be level " + armor.getRequiredLevel() + " or more. You are currently level " + this.level);
            } catch (InvalidArmorException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        this.equipment.put(armor.slot, armor);
    }
    public abstract double damage();
    public HeroAttribute totalAttributes(){
        HeroAttribute totalAttributes = new HeroAttribute(0,0,0);
        totalAttributes.addAttribute(this.levelAttributes[0]);
        for(Map.Entry<Slot, Item> set : this.equipment.entrySet()){
            if (set.getKey() != Slot.WEAPON && set.getValue() != null){
                totalAttributes.addAttribute(((Armor)set.getValue()).getAttribute());
            }
        }
        return totalAttributes;
    }
    public void Display(){
        StringBuilder display = new StringBuilder();
        display.append("Name: "+ this.name);
        display.append(" Class: " + this.getClass().getSimpleName());
        display.append(" Level: " + this.level);
        display.append(" Total strength: " + this.totalAttributes().strength);
        display.append(" Total dexterity: " + this.totalAttributes().dexterity);
        display.append(" Total intelligence: " + this.totalAttributes().intelligence);
        display.append(" Damage: " + this.damage());

        System.out.println(display.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public int getLevel() {
        return level;
    }

    public HeroAttribute[] getLevelAttributes() {
        return levelAttributes;
    }

    public List<WeaponType> getValidWeaponTypes() {
        return validWeaponTypes;
    }

    public List<ArmorType> getValidArmorTypes() {
        return validArmorTypes;
    }


}
