package utils;

import Models.Drink;
import Models.Ingredient;

public class comparator {

    public static boolean moreThanABV(Ingredient ing1,Ingredient ing2){
        double ABV1 = ing1.getABV();
        double ABV2 = ing2.getABV();
        return ABV1>=ABV2;
    }

    public static boolean moreThanABV(Drink dri1, Drink dri2){
        double ABV1 = dri1.getABV();
        double ABV2 = dri2.getABV();
        return ABV1>=ABV2;
    }

    public static boolean Alphabetical(Ingredient Obj1,Ingredient Obj2){
        int i = 0;
        char firstObj = 0;
        char secObj = 0;
        boolean compare;
        do {
            firstObj = Obj1.getName().toUpperCase().charAt(i);
            secObj = Obj2.getName().toUpperCase().charAt(i);
        } while (firstObj == secObj);
        return firstObj<secObj;
    }

    public static boolean Alphabetical(Drink Obj1,Drink Obj2){
        int i = 0;
        char firstObj = 0;
        char secObj = 0;
        boolean compare;
        do {
            firstObj = Obj1.getName().toUpperCase().charAt(i);
            secObj = Obj2.getName().toUpperCase().charAt(i);
        } while (firstObj == secObj);
        return firstObj<secObj;
    }

    public static double getABV(Drink drink){
        return drink.getABV();
    }

    public static double getABV(Ingredient ingredient){
        return ingredient.getABV();
    }

}
