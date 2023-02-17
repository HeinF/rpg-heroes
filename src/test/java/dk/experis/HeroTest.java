package dk.experis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;

    @BeforeEach
    void setup(){
        hero = new Mage("Merlin");
    }

    @Test
    void createHero_getName_shouldReturnName(){
        // Arrange
        String expected = "Merlin";

        // Act
        String actual = hero.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createHero_getLevel_shouldBeLevelOne(){
        // Arrange
        int expected = 1;

        // Act

        int actual = hero.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void equipWeapon_weaponWithLevelRequirementHigherThanHero_shouldThrowInvalidWeaponException(){
        // Arrange
        Weapon staff = new Weapon("Sceptre", 100, WeaponType.STAFF, 55);

        String expected = "To equip this weapon you must be level 100 or more. You are currently level 1";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> hero.equip(staff));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmor_armorWithLevelRequirementHigherThanHero_shouldThrowInvalidArmorException(){
        // Arrange
        Armor armor = new Armor("Robe of Merlin", 50, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(4, 12, 25));
        String expected = "To equip this armor you must be level 50 or more. You are currently level 1";

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> hero.equip(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAttributes_noEquipment_shouldReturnTotalAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,1,8);

        // Act
        HeroAttribute actual = hero.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAttributes_onePieceOfEquipment_shouldReturnTotalAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(3,6,16);
        Armor robe = new Armor("Robe of Merlin's  Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));


        // Act
        try {
            hero.equip(robe);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        HeroAttribute actual = hero.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAttributes_twoPiecesOfEquipment_shouldReturnTotalAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(4,7,21);
        Armor robe = new Armor("Robe of Merlin's  Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));
        Armor hat = new Armor("Hat of Merlin's  Apprentice", 1, Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1, 1, 5));


        // Act
        try {
            hero.equip(robe);
            hero.equip(hat);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        HeroAttribute actual = hero.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAttributes_replacedPieceOfEquipment_shouldReturnTotalAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(5,2,14);
        Armor robe = new Armor("Robe of Merlin's  Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));
        Armor robeReplacement = new Armor("Robe of Prospero's Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(4, 1, 6));


        // Act
        try {
            hero.equip(robe);
            hero.equip(robeReplacement);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        HeroAttribute actual = hero.totalAttributes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUp() {
    }

    @Test
    void equip() {
    }

    @Test
    void testEquip() {
    }

    @Test
    void damage() {
    }

    @Test
    void totalAttributes() {
    }

    @Test
    void display() {
    }
}