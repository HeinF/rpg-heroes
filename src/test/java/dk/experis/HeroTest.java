package dk.experis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;

    @Test
    void createHero_getName_shouldReturnName(){
        // Arrange
        hero = new Mage("Merlin");
        String expected = "Merlin";

        // Act
        String actual = hero.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void createHero_getLevel_shouldBeLevelOne(){
        // Arrange
        hero = new Mage("Merlin");
        int expected = 1;

        // Act

        int actual = hero.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void MageIsCreatedWithCorrectAttributes(){
        // Act & Arrange
        hero = new Mage("Merlin");
        HeroAttribute expected = new HeroAttribute(1,1,8);

        // Assert
        assertEquals(expected, hero.levelAttributes[0]);
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