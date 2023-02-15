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

        Weapon bow = new Weapon("Falco", 1, Slot.WEAPON, WeaponType.BOW, 10);

        equipment.put(bow.slot, bow);
        System.out.println("Hello world!");
        System.out.println(((Weapon)equipment.get(bow.slot)).weaponDamage);
        Weapon copy = (Weapon) equipment.get(bow.slot);
        System.out.println(bow);
        System.out.println(copy);
    }
}