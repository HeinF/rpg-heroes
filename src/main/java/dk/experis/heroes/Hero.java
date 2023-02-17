package dk.experis.heroes;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.exceptions.InvalidArmorException;
import dk.experis.exceptions.InvalidWeaponException;
import dk.experis.items.Armor;
import dk.experis.items.Item;
import dk.experis.items.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {


    private String name;
    protected int level;
    // On creation stores base attributes in index 0 and level gain attributes in index 1
    // On level up base attributes are increased by level gain attributes
    protected HeroAttribute[] levelAttributes;
    protected Map<Slot, Item> equipment;
    protected List<WeaponType> validWeaponTypes;
    protected List<ArmorType> validArmorTypes;


    // Superclass constructor
    public Hero(String name){
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
    // Increase current attributes by level gain attributes and then increase level by one
    public void levelUp(){
        this.levelAttributes[0].addAttribute(this.levelAttributes[1]);
        this.level++;
    }
    // Check if the hero can equip the weapon type and if the hero meets the level requirement of the weapon.
    // If so, add the given weapon to the equipment map in the weapon slot.
    // Otherwise, throw an InvalidWeaponException with an appropriate error message.
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if (!validWeaponTypes.contains(weapon.getType())){
                throw new InvalidWeaponException("Your Hero cannot equip weapons of type: "+ weapon.getType());
        }
        if (this.level < weapon.getRequiredLevel()){
                throw  new InvalidWeaponException("To equip this weapon you must be level "+ weapon.getRequiredLevel() + " or more. You are currently level " + this.level);
        }
        this.equipment.put(weapon.getSlot(), weapon);
    }
    // Check if the hero can equip the armor type and if the hero meets the level requirement of the armor.
    // If so, add the given armor to the equipment map in the slot specified by the armor.
    // Otherwise, throw an InvalidArmorException with an appropriate error message.
    public void equip(Armor armor) throws InvalidArmorException {
        if (!validArmorTypes.contains(armor.getType())){
                throw new InvalidArmorException("Your Hero can't equip armor of type: " + armor.getType());

        }
        if (this.level < armor.getRequiredLevel()){
                throw new InvalidArmorException("To equip this armor you must be level " + armor.getRequiredLevel() + " or more. You are currently level " + this.level);
        }
        this.equipment.put(armor.getSlot(), armor);
    }
    // Abstract method to be implemented in subclasses as the damage boosting attribute varies between subclasses
    public abstract double damage();
    // Calculates the total attributes of the hero by combining the base attributes for the level (found in levelAttributes index 0)
    // with the attributes of all equipped armor
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
    // Uses a StringBuilder to create a string with the Heroes information so that it can easily be displayed
    public String display(){
        StringBuilder display = new StringBuilder();
        display.append("Name: "+ this.name);
        display.append(" Class: " + this.getClass().getSimpleName());
        display.append(" Level: " + this.level);
        display.append(" Total strength: " + this.totalAttributes().strength);
        display.append(" Total dexterity: " + this.totalAttributes().dexterity);
        display.append(" Total intelligence: " + this.totalAttributes().intelligence);
        display.append(" Damage: " + this.damage());

        return display.toString();
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getEquipment(Slot slot) {
        return this.equipment.get(slot);
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
