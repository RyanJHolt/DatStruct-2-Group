package utils;

import Models.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"rawtypes", "unchecked"})
class shellSortTest {
    linkedList list = new linkedList();
    linkedList reverseList = new linkedList();
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;

    @BeforeEach
    void setUp() {
        ingredient1 = new Ingredient("aaa","description",66);
        ingredient2 = new Ingredient("bbb","test",32);
        ingredient3 = new Ingredient("ccc","description",25);
        ingredient4 = new Ingredient("ddd","test",22);
        list.addElementT(ingredient1);list.addElementT(ingredient2);list.addElementT(ingredient3);list.addElementT(ingredient4);
        reverseList.addElementH(ingredient1);reverseList.addElementH(ingredient2);reverseList.addElementH(ingredient3);reverseList.addElementT(ingredient4);
    }

    @AfterEach
    void tearDown() {
        list.clear();
        reverseList.clear();
    }

    @Test
    void sortABV() {
        shellSort.sortABV(reverseList);
        int i = 0;
        while (i < 4) {
            assertEquals(list.getElement(i).getContents().toString(), reverseList.getElement(i).getContents().toString());
            i++;
        }
    }

    @Test
    void sortAlpha() {
        shellSort.sortAlpha(reverseList);
        int i = 0;
        while (i < 4) {
            assertEquals(list.getElement(i).getContents().toString(), reverseList.getElement(i).getContents().toString());
            i++;
        }
    }
}