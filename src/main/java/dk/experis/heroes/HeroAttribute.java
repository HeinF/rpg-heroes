package dk.experis.heroes;

public class HeroAttribute {
    public int strength;
    public int dexterity;
    public int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // Adds attributes of another HeroAttribute to this HeroAttribute.
    // Used for example when levelling up or when calculating total attributes
    public void addAttribute(HeroAttribute toAdd){
        this.strength += toAdd.strength;
        this.dexterity += toAdd.dexterity;
        this.intelligence += toAdd.intelligence;
    }
    // Overrides the equals method so that HeroAttributes are compared by their attributes instead of an object comparison,
    // ie if two HerroAttributes has the same values for strength, dexterity and intelligence, they are considered equal and 'true' will be returned.
    @Override
    public boolean equals(Object o) {
        // If the object is the same attributes will also be the same, so return true
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        HeroAttribute compareTo = (HeroAttribute) o;

        return this.strength == compareTo.strength && this.dexterity == compareTo.dexterity && this.intelligence == compareTo.intelligence;
    }

}
