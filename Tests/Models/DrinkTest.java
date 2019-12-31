package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.linkedList;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    linkedList ing = new linkedList();
    Drink drink;

    @BeforeEach
    void setUp() {
        ing.addElementH(new Ingredient("name","description",22),100);
        ing.addElementH(new Ingredient("name","description",66),300);
        drink = new Drink("Name","place","description","url",ing);
    }

    @AfterEach
    void tearDown() {
        ing.deleteElement(0);
        drink = null;
    }

    @Test
    void getTotalQuantity() {
        assertEquals(drink.getTotalQuantity(), (drink.totalQuantity));
        assertEquals(drink.getTotalQuantity(), (400));
        assertNotEquals(drink.getTotalQuantity(), (0));
    }

    @Test
    void getABV() {
        assertEquals(drink.getABV(), (drink.ABV));
        assertEquals(drink.getABV(), (22));
        assertNotEquals(drink.getABV(), (0), 0.0);
    }

    @Test
    void addIngredient() {
        ing.addElementH(new Ingredient("name","description",22),100);
        assertEquals(ing.getHead().toString(), ing.getElement(0).toString());
        assertEquals(100, ing.getHead().getQuantity());
    }

    @Test
    void updateIngredient() {
        Ingredient temp = new Ingredient("name","description",22);
        ing.updateElement(0,temp,300);
        assertEquals(ing.getHead().getContents(), temp);
        assertEquals(300, ing.getHead().getQuantity());
    }

    @Test
    void deleteIngredient() {
        linkedList.linkedNode test = ing.getElement(1);
        ing.deleteElement(0);
        assertEquals(ing.getHead().getQuantity(), test.getQuantity());
    }
}