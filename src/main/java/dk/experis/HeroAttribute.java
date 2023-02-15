package dk.experis;

public class HeroAttribute {
    public int strength;
    public int dexterity;
    public int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void addAttribute(HeroAttribute toAdd){
        this.strength += toAdd.strength;
        this.dexterity += toAdd.dexterity;
        this.intelligence += toAdd.intelligence;
    }

}
