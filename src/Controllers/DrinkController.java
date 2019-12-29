package Controllers;

import Models.Drink;
import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.linkedList;

public class DrinkController {

    @FXML
    TextField name;
    @FXML
    TextField origin;
    @FXML
    TextField imageURL;
    @FXML
    TextArea description;
    @FXML
    ListView<Ingredient> ingredientList;

    @FXML
    void initialize() {
        ingredientList.getItems().clear();
        if (IngredientController.IngredientsList.size() > 0)
            for (linkedList.linkedNode i = IngredientController.IngredientsList.getHead(); i != null; i = i.next) {
                ingredientList.getItems().add((Ingredient)i.getContents());
            }
    }

    public static linkedList<Drink> DrinksList = new linkedList();

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

    @FXML
    public void addDrinkToList() {
        linkedList<Ingredient> l = new linkedList<>();
        l.addElementH(ingredientList.getSelectionModel().getSelectedItem(), (int)ingredientList.getSelectionModel().getSelectedItem().getABV());
        Drink d = new Drink(name.getText(), origin.getText(), description.getText(), imageURL.getText(), l);
        addDrink(d);
    }

    /*public linkedList searchDrinkName(String drinkName){
        linkedList<Drink> searchedDrinks = new linkedList();
        for (int i = 0; i < getDrinksList().size(); i++){
            if ()
        }
        return searchedDrinks; */
}