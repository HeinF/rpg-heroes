package dk.experis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    Item weapon;
    @BeforeEach
    void setup(){
        weapon = new Weapon("Excalibur", 100, WeaponType.SWORD, 35);
    }
    @Test
    void weaponCreated_getName_shouldReturnName(){
        //Arrange
        String expected = "Excalibur";

        //Act
        String actual = weapon.getName();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void weaponCreated_getRequiredLevel_shouldReturnRequiredLevel(){
        //Arrange
        int expected = 100;

        //Act
        int actual = weapon.getRequiredLevel();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void weaponCreated_getSlot_shouldReturnSlot(){
        //Arrange
        Slot expected = Slot.WEAPON;

        //Act
        Slot actual = weapon.getSlot();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void weaponCreated_getWeaponType_shouldReturnWeaponType(){
        //Arrange
        WeaponType expected = WeaponType.SWORD;

        //Act
        WeaponType actual = ((Weapon)weapon).getType();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void weaponCreated_getWeaponDamage_shouldReturnWeaponDamage(){
        //Arrange
        double expected = 35;

        //Act
        double actual = ((Weapon)weapon).getWeaponDamage();
        // Assert
        assertEquals(expected, actual);
    }

}