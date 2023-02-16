package dk.experis;

public class Armor extends Item {

    public ArmorType type;
    public HeroAttribute attribute;
    public Armor(String name, int requiredLevel, Slot slot,  ArmorType type, HeroAttribute attribute) {
        super(name, requiredLevel);
        this.slot = slot;
        this.type = type;
        this.attribute = attribute;
    }
}
