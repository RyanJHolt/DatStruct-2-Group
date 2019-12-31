package utils;

import Models.Drink;
import Models.Ingredient;

@SuppressWarnings("rawtypes")
public class comparator {

    public static boolean moreThanABV(linkedList.linkedNode obj1, linkedList.linkedNode obj2) {
        double ABV1 = 0;
        double ABV2 = 2;
        if (obj1.getContents().getClass().getName().equals("Drink") && obj2.getContents().getClass().getName().equals("Drink")) {
            Drink comp1 = (Drink) obj1.getContents();
            Drink comp2 = (Drink) obj2.getContents();
            ABV1 = comp1.getABV();
            ABV2 = comp2.getABV();
        } else if (obj1.getContents().getClass().getName().equals("Ingredient") && obj2.getContents().getClass().getName().equals("Ingredient")) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            Ingredient comp2 = (Ingredient) obj2.getContents();
            ABV1 = comp1.getABV();
            ABV2 = comp2.getABV();
        }
        return (ABV1 >= ABV2);
    }

    public static boolean Alphabetical(linkedList.linkedNode obj1, linkedList.linkedNode obj2) {
        int i = 0;
        char firstObj;
        char secObj;
        String objName1;
        String objName2;
        if (obj1.getContents().getClass().getName().equals("Drink") && obj2.getContents().getClass().getName().equals("Drink")) {
            Drink comp1 = (Drink) obj1.getContents();
            Drink comp2 = (Drink) obj2.getContents();
            objName1 = comp1.getName();
            objName2 = comp2.getName();
        } else if (obj1.getContents().getClass().getName().equals("Ingredient") && obj2.getContents().getClass().getName().equals("Ingredient")) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            Ingredient comp2 = (Ingredient) obj2.getContents();
            objName1 = comp1.getName();
            objName2 = comp2.getName();
        } else return false;
        do {
            firstObj = objName1.toUpperCase().charAt(i);
            secObj = objName2.toUpperCase().charAt(i);
        } while (firstObj == secObj);
        return firstObj <= secObj;
    }

    public static boolean Contains(linkedList.linkedNode obj1, String str1) {
        String str2 = "";
        if (obj1.getContents().getClass().getName().equals("Drink")) {
            Drink comp1 = (Drink) obj1.getContents();
            str2 = comp1.getName();
        } else if (obj1.getContents().getClass().getName().equals("Ingredient")) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            str2 = comp1.getName();
        }
        return str2.toUpperCase().contains(str1.toUpperCase());
    }

}
