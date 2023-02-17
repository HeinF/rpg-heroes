package dk.experis.items;

import dk.experis.enums.Slot;

public abstract class Item {


    private String name;
    private int requiredLevel;
    protected Slot slot;
    // Superclass constructor
    public Item(String name, int requiredLevel){
        this.name = name;
        this.requiredLevel = requiredLevel;
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }
}
