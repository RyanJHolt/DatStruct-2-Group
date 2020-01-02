package utils;

import Models.Drink;
import Models.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class hashMapTest {
    linkedList ing = new linkedList();
    Drink drink;
    hashMap hash = new hashMap();

    @BeforeEach
    void setUp() {
        ing.addElementH(new Ingredient("name","description",22),100);
        ing.addElementH(new Ingredient("name","description",22),100);
        drink = new Drink("Name","place","description","url",ing);
        hash.add(drink.getName(),drink);
    }

    @AfterEach
    void tearDown() {
        hash.removeKey(drink.getName());
        drink = null;
    }

    @Test
    void get() {
        Drink drink2 = new Drink("test","place","description","url",ing);
        assertEquals(drink,hash.get("Name"));
        assertNotEquals(drink,hash.get("test"));
    }

    @Test
    void add() {
        Drink drink2 = new Drink("test","place","description","url",ing);
        hash.add("test",drink2);
        assertEquals(drink2,hash.get("test"));
        assertNotEquals(drink2,hash.get("Name"));
    }

    @Test
    void removeKey() {
        hash.removeKey(drink.getName());
        assertTrue(hash.isEmpty());
    }

    @Test
    void getSize() {
        assertEquals(1,hash.getSize());
        assertNotEquals(2,hash.getSize());
    }

    @Test
    void isEmpty() {
        assertFalse(hash.isEmpty());
        hash.removeKey(drink.getName());
        assertTrue(hash.isEmpty());
        hash.add(drink.getName(),drink);
    }

    @Test
    void getHashIndex() {
        assertEquals(5,hash.getHashIndex(drink.getName()));
    }

    @Test
    void keyContains(){
        linkedList test = new linkedList();
        linkedList result2 = hash.keyContains("te");
        Drink drink2 = new Drink("test","place","description","url",ing);
        assertEquals(null,result2);

        hash.add(drink2.getName(),drink2);
        result2 = hash.keyContains("test");
        assertEquals(drink2,result2.getHead().getContents());
    }
}