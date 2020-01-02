package utils;

import Models.Drink;
import Models.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//INCOMPLETE
class comparatorTest {
    linkedList DrinkList1 = new linkedList();
    linkedList DrinkList2 = new linkedList();
    linkedList IngredientList1 = new linkedList();
    linkedList IngredientList2 = new linkedList();
    String string = "drink";
    Ingredient ing1 = new Ingredient("zzzz",string,30);
    Ingredient ing2 = new Ingredient("aaaa",string,22);
    Drink dri1 = new Drink("bbbb", string,string,string,IngredientList1);
    Drink dri2 = new Drink("bdbb", string,string,string,IngredientList2);

    @BeforeEach
    void setUp() {
        string = "drink";
        ing1 = new Ingredient("zzzz",string,30);
        ing2 = new Ingredient("aaaa",string,22);
        IngredientList1.addElementH(ing1,100);
        IngredientList2.addElementH(ing2,100);
        dri1 = new Drink("bbbb", string,string,string,IngredientList1);
        dri2 = new Drink("bdbb", string,string,string,IngredientList2);
        DrinkList1.addElementH(dri1);
        DrinkList2.addElementH(dri2);
    }

    @AfterEach
    void tearDown() {
        IngredientList1 = null;IngredientList2 = null;
        DrinkList1 = null;DrinkList2 = null;
        string = null;
        ing1 = null;ing2 = null;
        dri1 = null;dri2 = null;
    }

    @Test
    void moreThanABV() {
        assertTrue(comparator.moreThanABV(DrinkList1.getHead(),DrinkList2.getHead()));
        assertFalse(comparator.moreThanABV(DrinkList2.getHead(),DrinkList1.getHead()));
        assertFalse(comparator.moreThanABV(IngredientList2.getHead(),IngredientList1.getHead()));
        assertTrue(comparator.moreThanABV(IngredientList1.getHead(),DrinkList2.getHead()));
        assertTrue(comparator.moreThanABV(IngredientList2.getHead(),IngredientList2.getHead()));
        assertTrue(comparator.moreThanABV(DrinkList1.getHead(),DrinkList1.getHead()));
    }

    @Test
    void alphabetical() {
        assertTrue(comparator.alphabetical(DrinkList1.getHead(),DrinkList2.getHead()));
        assertFalse(comparator.alphabetical(DrinkList2.getHead(),DrinkList1.getHead()));
        assertFalse(comparator.alphabetical(IngredientList1.getHead(),IngredientList2.getHead()));
        assertTrue(comparator.alphabetical(IngredientList2.getHead(),DrinkList1.getHead()));
        assertTrue(comparator.alphabetical(IngredientList2.getHead(),IngredientList2.getHead()));
        assertTrue(comparator.alphabetical(DrinkList1.getHead(),DrinkList1.getHead()));
    }

    @Test
    void contains() {
        linkedList.linkedNode test = new linkedList.linkedNode(dri1);
        assertTrue(comparator.contains(test,"bb"));
        assertFalse(comparator.contains(test,"bwadas"));
    }
}