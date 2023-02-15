package dk.experis;

public class Mage extends Hero {
    protected Mage(String name) {
        super(name);

        this.levelAttributes = new HeroAttribute[]{new HeroAttribute(1,1,8), new HeroAttribute(1,1,5)};
    }

    @Override
    public String EquipWeapon() {
        return null;
    }

    @Override
    public String EquipArmor() {
        return null;
    }

    @Override
    public double Damage() {
        return 0;
    }

    @Override
    public void TotalAttributes() {

    }

    @Override
    public void Display() {

    }
}
