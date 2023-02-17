package dk.experis;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.exceptions.InvalidArmorException;
import dk.experis.exceptions.InvalidWeaponException;
import dk.experis.heroes.Hero;
import dk.experis.heroes.HeroAttribute;
import dk.experis.heroes.Ranger;
import dk.experis.items.Armor;
import dk.experis.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    Hero ranger;

    @BeforeEach
    void setup(){
        ranger = new Ranger("Din Djarin");
    }

    @Test
    void createRanger_getBaseLevelAttributes_shouldReturnBaseLevelAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,7,1);

        // Act
        HeroAttribute actual = ranger.getLevelAttributes()[0];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createRanger_getLevelGainAttributes_shouldReturnLevelGainAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,5,1);

        // Act
        HeroAttribute actual = ranger.getLevelAttributes()[1];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpRanger_getLevel_shouldReturnNewLevel(){
        // Arrange
        int expected = 2;

        // Act
        ranger.levelUp();
        int actual = ranger.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpRanger_getAttributes_shouldReturnUpdatedAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(2,12,2);

        // Act
        ranger.levelUp();
        HeroAttribute actual = ranger.getLevelAttributes()[0];

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    void equipWeapon_weaponOfWrongWeaponType_shouldThrowInvalidWeaponException(){
        // Arrange
        Weapon sword = new Weapon("Excalibur", 1, WeaponType.SWORD, 35);
        String expected = "Your Hero cannot equip weapons of type: SWORD";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> ranger.equip(sword));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmor_armorOfWrongArmorType_shouldThrowInvalidArmorException(){
        // Arrange
        Armor armor = new Armor("Armor of Achilles", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(20, 30, 10));
        String expected = "Your Hero can't equip armor of type: PLATE";

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> ranger.equip(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void damage_noWeaponEquipped_shouldReturnUnarmedDamage(){
        // Arrange
        double expected = 1.07;

        // Act
        double actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon bow = new Weapon("Longbow", 1, WeaponType.BOW, 8);
        double expected = 8.56;

        // Act
        try {
            ranger.equip(bow);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponReplacedEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon bow = new Weapon("Longbow", 1, WeaponType.BOW, 8);
        Weapon bowReplacement = new Weapon("Arblast", 1, WeaponType.BOW, 12);
        double expected = 12.84;

        // Act
        try {
            ranger.equip(bow);
            ranger.equip(bowReplacement);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponAndArmorEquipped_shouldReturnArmedDamageWithArmorBoost(){
        // Arrange
        Weapon bow = new Weapon("Longbow", 1, WeaponType.BOW, 8);
        Armor mail = new Armor("Chain mail", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(3, 9, 1));
        double expected = 9.28;

        // Act
        try {
            ranger.equip(bow);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            ranger.equip(mail);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }

        double actual = ranger.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void display_displayRanger_shouldReturnDisplayString(){
        // Arrange
        String expected = "Name: Din Djarin Class: Ranger Level: 1 Total strength: 1 Total dexterity: 7 Total intelligence: 1 Damage: 1.07";

        // Act
        String actual = ranger.display();

        // Assert
        assertEquals(expected, actual);
    }

}