package dk.experis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Item armor;
    @BeforeEach
    void setup(){
        armor = new Armor("Robe of Merlin's Apprentice", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 5, 8));
    }

    @Test
    void armorCreated_getName_shouldReturnName() {
        // Arrange
        String expected = "Robe of Merlin's Apprentice";

        // Act
        String actual = armor.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void armorCreated_getRequiredLevel_shouldReturnRequiredLevel() {
        // Arrange
        int expected = 1;

        // Act
        int actual = armor.getRequiredLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void weaponCreated_getSlot_shouldReturnSlot() {
        // Arrange
        Slot expected = Slot.BODY;

        // Act
        Slot actual = armor.getSlot();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void armorCreated_getArmorType_shouldReturnArmorType() {
        // Arrange
        ArmorType expected = ArmorType.CLOTH;

        // Act
        ArmorType actual = ((Armor)armor).getType();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void armorCreated_getArmorAttributes_shouldReturnArmorAttributes() {
        // Arrange
        HeroAttribute expected = new HeroAttribute(2, 5, 8);

        // Act
        HeroAttribute actual = ((Armor)armor).getAttribute();

        // Assert
        assertEquals(expected, actual);
    }

}