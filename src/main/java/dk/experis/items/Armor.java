package dk.experis.items;

import dk.experis.enums.ArmorType;
import dk.experis.heroes.HeroAttribute;
import dk.experis.enums.Slot;

public class Armor extends Item {

    private ArmorType type;
    private HeroAttribute attribute;
    // Subclass constructor
    public Armor(String name, int requiredLevel, Slot slot, ArmorType type, HeroAttribute attribute) {
        super(name, requiredLevel);
        this.slot = slot;
        this.type = type;
        this.attribute = attribute;
    }
    // Getters
    public ArmorType getType() {
        return type;
    }

    public HeroAttribute getAttribute() {
        return attribute;
    }
}
