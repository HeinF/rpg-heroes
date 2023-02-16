package dk.experis;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Slot, Item> equipment = new HashMap<>();
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);

        Weapon bow = new Weapon("Falco", 2, WeaponType.WAND, 1);

        equipment.put(bow.slot, bow);
        System.out.println("Hello world!");
        System.out.println(((Weapon)equipment.get(bow.slot)).weaponDamage);
        Weapon copy = (Weapon) equipment.get(bow.slot);
        System.out.println(bow);
        System.out.println(copy);

        Mage harry = new Mage("Potter");
        System.out.println(harry.levelAttributes[0].intelligence);
        harry.LevelUp();
        System.out.println(harry.levelAttributes[0].intelligence);
        harry.Equip(bow);
        System.out.println(harry.TotalAttributes().intelligence);

        Armor hat = new Armor("Sorting hat", 2, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,10));
        harry.Equip(hat);
        System.out.println(harry.TotalAttributes().intelligence);

        System.out.println(harry.Damage());

        harry.Display();


    }
}