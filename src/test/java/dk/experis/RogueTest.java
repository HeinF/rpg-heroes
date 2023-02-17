package dk.experis;

import dk.experis.enums.ArmorType;
import dk.experis.enums.Slot;
import dk.experis.enums.WeaponType;
import dk.experis.exceptions.InvalidArmorException;
import dk.experis.exceptions.InvalidWeaponException;
import dk.experis.heroes.Hero;
import dk.experis.heroes.HeroAttribute;
import dk.experis.heroes.Rogue;
import dk.experis.items.Armor;
import dk.experis.items.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    Hero rouge;

    @BeforeEach
    void setup(){
        rouge = new Rogue("Garrett");
    }

    @Test
    void createRouge_getBaseLevelAttributes_shouldReturnBaseLevelAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(2,6,1);

        // Act
        HeroAttribute actual = rouge.getLevelAttributes()[0];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createRouge_getLevelGainAttributes_shouldReturnLevelGainAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(1,4,1);

        // Act
        HeroAttribute actual = rouge.getLevelAttributes()[1];

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpRouge_getLevel_shouldReturnNewLevel(){
        // Arrange
        int expected = 2;

        // Act
        rouge.levelUp();
        int actual = rouge.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void levelUpRouge_getAttributes_shouldReturnUpdatedAttributes(){
        // Arrange
        HeroAttribute expected = new HeroAttribute(3,10,2);

        // Act
        rouge.levelUp();
        HeroAttribute actual = rouge.getLevelAttributes()[0];

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    void equipWeapon_weaponOfWrongWeaponType_shouldThrowInvalidWeaponException(){
        // Arrange
        Weapon bow = new Weapon("Longbow", 1, WeaponType.BOW, 8);
        String expected = "Your Hero cannot equip weapons of type: BOW";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> rouge.equip(bow));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmor_armorOfWrongArmorType_shouldThrowInvalidArmorException(){
        // Arrange
        Armor armor = new Armor("Armor of Achilles", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(20, 30, 10));
        String expected = "Your Hero can't equip armor of type: PLATE";

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> rouge.equip(armor));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void damage_noWeaponEquipped_shouldReturnUnarmedDamage(){
        // Arrange
        double expected = 1.06;

        // Act
        double actual = rouge.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon dagger = new Weapon("Glamdring", 1, WeaponType.DAGGER, 7);
        double expected = 7.42;

        // Act
        try {
            rouge.equip(dagger);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = rouge.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponReplacedEquipped_shouldReturnArmedDamage(){
        // Arrange
        Weapon dagger = new Weapon("Glamdring", 1, WeaponType.DAGGER, 7);
        Weapon daggerReplacement = new Weapon("Sgian-dubh", 1, WeaponType.DAGGER, 5);
        double expected = 5.3;

        // Act
        try {
            rouge.equip(dagger);
            rouge.equip(daggerReplacement);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        double actual = rouge.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void damage_WeaponAndArmorEquipped_shouldReturnArmedDamageWithArmorBoost(){
        // Arrange
        Weapon dagger = new Weapon("Glamdring", 1, WeaponType.DAGGER, 7);
        Armor mail = new Armor("Chain mail", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(3, 9, 1));
        double expected = 8.05;

        // Act
        try {
            rouge.equip(dagger);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            rouge.equip(mail);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }

        double actual = rouge.damage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void display_displayRogue_shouldReturnDisplayString(){
        // Arrange
        String expected = "Name: Garrett Class: Rogue Level: 1 Total strength: 2 Total dexterity: 6 Total intelligence: 1 Damage: 1.06";

        // Act
        String actual = rouge.display();

        // Assert
        assertEquals(expected, actual);
    }

}