package dk.experis;

public abstract class Item {



    private int requiredLevel;
    protected Slot slot;

    public Item(String name, int requiredLevel){
        this.name = name;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }
}
