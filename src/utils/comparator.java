package utils;

import Models.Drink;
import Models.Ingredient;

@SuppressWarnings("rawtypes")
public class comparator {

    public static boolean moreThanABV(linkedList.linkedNode obj1, linkedList.linkedNode obj2) {
        double ABV1;
        double ABV2;
        //converts both node to whichever object type and stores their ABV as doubles
        switch (obj1.getContents().getClass().getName()){
            case "Models.Drink":
                Drink dri1 = (Drink) obj1.getContents();
                ABV1 = dri1.getABV();
                break;
            case "Models.Ingredient":
                Ingredient ing1 = (Ingredient) obj1.getContents();
                ABV1 = ing1.getABV();
                break;
            default:
                return false;
        }
        switch (obj2.getContents().getClass().getName()){
            case "Models.Drink":
                Drink dri2 = (Drink) obj2.getContents();
                ABV2 = dri2.getABV();
                break;
            case "Models.Ingredient":
                Ingredient ing2 = (Ingredient) obj2.getContents();
                ABV2 = ing2.getABV();
                break;
            default:
                return false;
        }
        return (ABV1 >= ABV2); //returns true if ABV1 is larger than or equal to ABV2
    }

    public static boolean alphabetical(linkedList.linkedNode obj1, linkedList.linkedNode obj2) {
        char firstObj; //initialising the chars to compare
        char secObj;
        String objName1; //initialising the Strings the chars will be taken from
        String objName2;
        //converts both node to whichever object type and stores their names as Strings
        switch (obj1.getContents().getClass().getName()){
            case "Models.Drink":
                Drink dri1 = (Drink) obj1.getContents();
                objName1 = dri1.getName();
                break;
            case "Models.Ingredient":
                Ingredient ing1 = (Ingredient) obj1.getContents();
                objName1 = ing1.getName();
                break;
            default:
                return false;
        }
        switch (obj2.getContents().getClass().getName()){
            case "Models.Drink":
                Drink dri2 = (Drink) obj2.getContents();
                objName2 = dri2.getName();
                break;
            case "Models.Ingredient":
                Ingredient ing2 = (Ingredient) obj2.getContents();
                objName2 = ing2.getName();
                break;
            default:
                return false;
        }
        int i = 0; //initialise loop variable for comparing the chars
        do { //in the case that both chars match the loop continues until either one of the words ends or it finds too letters that dont match
            firstObj = objName1.toUpperCase().charAt(i);
            secObj = objName2.toUpperCase().charAt(i);
            ++i;
        } while (firstObj == secObj && i < objName1.length() && i < objName2.length());
        return firstObj <= secObj; //returns true if the first word is before the second word in alphabetical order
    }

    //small function to check if the name of of ingredients or drinks contains a string
    //able to be used for searching through a list of both drink and ingredients
    public static boolean contains(linkedList.linkedNode obj1, String str1) {
        String str2 = "";
        if (obj1.getContents().getClass() == Drink.class) {
            Drink comp1 = (Drink) obj1.getContents();
            str2 = comp1.getName().toUpperCase();
        } else if (obj1.getContents().getClass() == Ingredient.class) {
            Ingredient comp1 = (Ingredient) obj1.getContents();
            str2 = comp1.getName().toUpperCase();
        }
        return str2.contains(str1.toUpperCase());
    }

}
