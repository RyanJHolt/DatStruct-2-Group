package Controllers;

import Models.Drink;
import utils.linkedList;

public class DrinkController {

    linkedList<Drink> DrinksList = new linkedList();

    public void addDrink(Drink drink) {
        DrinksList.addElementH(drink);
    }

    public void updateDrink(int n, Drink drink) {
        DrinksList.updateElement(n, drink);
    }

    public void deleteDrink(int n) {
        deleteDrink(n);
    }

    public linkedList<Drink> getDrinksList() {
        return DrinksList;
    }

    public void setDrinksList(linkedList<Drink> drinksList) {
        DrinksList = drinksList;
    }

    /*public linkedList searchDrinkName(String drinkName){
        linkedList<Drink> searchedDrinks = new linkedList();
        for (int i = 0; i < getDrinksList().size(); i++){
            if ()
        }
        return searchedDrinks; */
}