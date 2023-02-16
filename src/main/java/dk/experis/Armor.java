package dk.experis;

public class Armor extends Item {



    private ArmorType type;
    private HeroAttribute attribute;
    public Armor(String name, int requiredLevel, Slot slot,  ArmorType type, HeroAttribute attribute) {
        super(name, requiredLevel);
        this.slot = slot;
        this.type = type;
        this.attribute = attribute;
    }

    public ArmorType getType() {
        return type;
    }

    public HeroAttribute getAttribute() {
        return attribute;
    }
}
