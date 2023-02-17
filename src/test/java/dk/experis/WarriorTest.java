package dk.experis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Hero warrior;

    @BeforeEach
    void setup(){
        warrior = new Warrior("Roland");
    }

    @Test
    void createWarrior_getBaseLevelAttributes_shouldReturnBaseLevelAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(5,2,1);

        // Act
        HeroAttribute actual = warrior.getLevelAttributes()[0];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createWarrior_getLevelGainAttributes_shouldReturnLevelGainAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(3,2,1);

        // Act
        HeroAttribute actual = warrior.getLevelAttributes()[1];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpWarrior_getLevel_shouldReturnNewLevel(){
        // Arrange
        int expected = 2;

        // Act
        warrior.levelUp();
        int actual = warrior.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpWarrior_getAttributes_shouldReturnUpdatedAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(8,4,2);

        // Act
        warrior.levelUp();
        HeroAttribute actual = warrior.getLevelAttributes()[0];

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    void equipWeapon_weaponOfWrongWeaponType_shouldThrowInvalidWeaponException(){
        // Arrange
        Weapon bow = new Weapon("Longbow", 1, WeaponType.BOW, 8);
        String expected = "Your Hero cannot equip weapons of type: BOW";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> warrior.equip(bow));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmor_armorOfWrongArmorType_shouldThrowInvalidArmorException(){
        // Arrange
        Armor armor = new Armor("Robe of Merlin's  Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));
        String expected = "Your Hero can't equip armor of type: CLOTH";

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> warrior.equip(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void damage_noWeaponEquipped_shouldReturnUnarmedDamage(){
        // Arrange
        double expected = 1.05;

        // Act
        double actual = warrior.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon sword = new Weapon("Excalibur", 1, WeaponType.SWORD, 35);
        double expected = 36.75;

        // Act
        try {
            warrior.equip(sword);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = warrior.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponReplacedEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon sword = new Weapon("Excalibur", 1, WeaponType.SWORD, 35);
        Weapon swordReplacement = new Weapon("Durendal", 1, WeaponType.SWORD, 27);
        double expected = 28.35;

        // Act
        try {
            warrior.equip(sword);
            warrior.equip(swordReplacement);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = warrior.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponAndArmorEquipped_shouldReturnArmedDamageWithArmorBoost(){
        // Arrange
        Weapon sword = new Weapon("Excalibur", 1, WeaponType.SWORD, 35);
        Armor armor = new Armor("Armor of Achilles", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(20, 30, 10));
        double expected = 43.75;

        // Act
        try {
            warrior.equip(sword);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            warrior.equip(armor);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }

        double actual = warrior.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void display_displayWarrior_shouldReturnDisplayString(){
        // Arrange
        String expected = "Name: Roland Class: Warrior Level: 1 Total strength: 5 Total dexterity: 2 Total intelligence: 1 Damage: 1.05";

        // Act
        String actual = warrior.display();

        // Assert
        assertEquals(expected, actual);
    }

}