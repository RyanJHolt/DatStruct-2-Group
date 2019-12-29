package utils;

import Models.Drink;
import Models.Ingredient;

public class comparator {

    public static boolean moreThanABV(linkedList.linkedNode obj1,linkedList.linkedNode obj2){
        double ABV1 = 0;
        double ABV2 = 0;
        if (obj1.getContents() == Drink.class && obj2.getContents() == Drink.class){
            Drink comp1 = (Drink) obj1.getContents();
            Drink comp2 = (Drink) obj2.getContents();
            ABV1 = comp1.getABV();
            ABV2 = comp2.getABV();
        } else if (obj1.getContents() == Ingredient.class && obj2.getContents() == Ingredient.class) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            Ingredient comp2 = (Ingredient) obj2.getContents();
            ABV1 = comp1.getABV();
            ABV2 = comp2.getABV();
        }
        return ABV1 >= ABV2;
    }

    public static boolean Alphabetical(linkedList.linkedNode obj1,linkedList.linkedNode obj2){
        int i = 0;
        char firstObj = 0;
        char secObj = 0;
        String objName1 = "";
        String objName2 = "";
        if (obj1.getContents() == Drink.class && obj2.getContents() == Drink.class){
            Drink comp1 = (Drink) obj1.getContents();
            Drink comp2 = (Drink) obj2.getContents();
            objName1 = comp1.getName();
            objName2 = comp2.getName();
        } else if (obj1.getContents() == Ingredient.class && obj2.getContents() == Ingredient.class) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            Ingredient comp2 = (Ingredient) obj2.getContents();
            objName1 = comp1.getName();
            objName2 = comp2.getName();
        }
        do {
            firstObj = objName1.toUpperCase().charAt(i);
            secObj = objName2.toUpperCase().charAt(i);
        } while (firstObj == secObj);
        return firstObj <= secObj;
    }

}
