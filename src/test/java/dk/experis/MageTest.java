package dk.experis;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.exceptions.InvalidArmorException;
import dk.experis.exceptions.InvalidWeaponException;
import dk.experis.heroes.Hero;
import dk.experis.heroes.HeroAttribute;
import dk.experis.heroes.Mage;
import dk.experis.items.Armor;
import dk.experis.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    Hero mage;

    @BeforeEach
    void setup(){
        mage = new Mage("Merlin");
    }

    @Test
    void createMage_getBaseLevelAttributes_shouldReturnBaseLevelAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,1,8);

        // Act
        HeroAttribute actual = mage.getLevelAttributes()[0];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createMage_getLevelGainAttributes_shouldReturnLevelGainAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,1,5);

        // Act
        HeroAttribute actual = mage.getLevelAttributes()[1];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpMage_getLevel_shouldReturnNewLevel(){
        // Arrange
        int expected = 2;

        // Act
        mage.levelUp();
        int actual = mage.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpMage_getAttributes_shouldReturnUpdatedAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(2,2,13);

        // Act
        mage.levelUp();
        HeroAttribute actual = mage.getLevelAttributes()[0];

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    void equipWeapon_weaponOfWrongWeaponType_shouldThrowInvalidWeaponException(){
        // Arrange
        Weapon sword = new Weapon("Excalibur", 1, WeaponType.SWORD, 35);
        String expected = "Your Hero cannot equip weapons of type: SWORD";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> mage.equip(sword));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmor_armorOfWrongArmorType_shouldThrowInvalidArmorException(){
        // Arrange
        Armor armor = new Armor("Armor of Achilles", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(20, 30, 10));
        String expected = "Your Hero can't equip armor of type: PLATE";

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> mage.equip(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void damage_noWeaponEquipped_shouldReturnUnarmedDamage(){
        // Arrange
        double expected = 1.08;

        // Act
        double actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon wand = new Weapon("Wand of Ronald Weasley", 1, WeaponType.WAND, 5);
        double expected = 5.4;

        // Act
        try {
            mage.equip(wand);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponReplacedEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon wand = new Weapon("Wand of Ronald Weasley", 1, WeaponType.WAND, 5);
        Weapon wandReplacement = new Weapon("Second Wand of Ronald Weasley", 1, WeaponType.WAND, 9);
        double expected = 9.72;

        // Act
        try {
            mage.equip(wand);
            mage.equip(wandReplacement);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponAndArmorEquipped_shouldReturnArmedDamageWithArmorBoost(){
        // Arrange
        Weapon wand = new Weapon("Wand of Ronald Weasley", 1, WeaponType.WAND, 5);
        Armor robe = new Armor("Robe of Merlin's Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));
        double expected = 5.8;

        // Act
        try {
            mage.equip(wand);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            mage.equip(robe);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }

        double actual = mage.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void display_displayMage_shouldReturnDisplayString(){
        // Arrange
        String expected = "Name: Merlin Class: Mage Level: 1 Total strength: 1 Total dexterity: 1 Total intelligence: 8 Damage: 1.08";

        // Act
        String actual = mage.display();

        // Assert
        assertEquals(expected, actual);
    }
}