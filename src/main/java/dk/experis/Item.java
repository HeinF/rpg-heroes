package dk.experis;

public abstract class Item {

    public String name;
    public int requiredLevel;
    public Slot slot;

    public Item(String name, int requiredLevel, Slot slot){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
}
