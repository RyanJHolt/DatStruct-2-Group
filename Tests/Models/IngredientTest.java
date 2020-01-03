package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.linkedList;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    Ingredient ingredient1;
    Drink drink1;

    @BeforeEach
    void setUp() {
        ingredient1 = new Ingredient("name","description",22);
        drink1 = new Drink("Name","place","descrip","pic",new linkedList());
        drink1.addIngredient(ingredient1);
        ingredient1.addDrink(drink1);
    }

    @AfterEach
    void tearDown() {
        ingredient1 = null;
        drink1 = null;
    }

    @Test
    void contains() {
        assertTrue(ingredient1.contains("Nam"));
    }

    @Test
    void getDrinks() {
        assertEquals(drink1.toString(),ingredient1.getDrinks().getHead().getContents().toString());
    }

    @Test
    void addDrink() {
        Drink drink =  new Drink("Test","place","descrip","pic",new linkedList());
        ingredient1.addDrink(drink);
        assertNotEquals(drink1.toString(),ingredient1.getDrinks().getHead().getContents().toString());
        assertEquals(drink.toString(),ingredient1.getDrinks().getHead().getContents().toString());

    }

    @Test
    void removeDrink() {
        assertNotEquals(0, ingredient1.getDrinks().size());
        ingredient1.removeDrink(0);
        assertEquals(0, ingredient1.getDrinks().size());
    }

    @Test
    void editDrink() {
        Drink drink =  new Drink("Name","place","descrip","pic",new linkedList());
        assertEquals(drink1.toString(),ingredient1.getDrinks().getHead().getContents().toString());
        ingredient1.editDrink(0,drink);
        assertEquals(drink.toString(),ingredient1.getDrinks().getHead().getContents().toString());
    }
}