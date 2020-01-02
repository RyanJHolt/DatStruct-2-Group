package utils;

import Models.Drink;
import Models.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class shellSortTest {
    linkedList list = new linkedList();
    linkedList reverseList = new linkedList();
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;

    @BeforeEach
    void setUp() {
        ingredient1 = new Ingredient("aaa","description",63);
        ingredient2 = new Ingredient("abb","test",22);
        ingredient3 = new Ingredient("xczz","description",11);
        list.addElementT(ingredient1);list.addElementT(ingredient2);list.addElementT(ingredient3);
        reverseList.addElementH(ingredient1);reverseList.addElementH(ingredient2);reverseList.addElementH(ingredient3);
    }

    @AfterEach
    void tearDown() {
        list.clear();
        reverseList.clear();
    }

    @Test
    void sortABV() {

    }

    @Test
    void sortAlpha() {
        shellSort.sortAlpha(reverseList); //some weirdness
        assertEquals(list.getHead().getContents(),reverseList.getHead().getContents());
    }
}