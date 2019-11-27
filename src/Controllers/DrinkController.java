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
}