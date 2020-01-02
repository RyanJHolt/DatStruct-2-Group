package Controllers;

import Models.Drink;
import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.Sanitization;
import utils.hashMap;
import utils.linkedList;
import utils.shellSort;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class DrinkController {

    //public static linkedList<Drink> DrinksList = new linkedList();
    public static hashMap<String, Drink> DrinksMap = new hashMap<>();
    @FXML
    TextField name;
    @FXML
    TextField origin;
    @FXML
    TextField imageURL;
    @FXML
    TextArea description;
    @FXML
    ListView<hashMap.hashNode> ingredientList;

    @FXML
    void initialize() {
        ingredientList.getItems().clear();
        ingredientList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if (!IngredientController.getIngredientMap().isEmpty()) {
            for (hashMap.hashNode tempNode : DrinksMap.hashArray) {
                while (tempNode != null) {
                    ingredientList.getItems().add(tempNode);
                    tempNode = tempNode.getNext();
                }
            }
        }

    }

    public void addDrink(Drink drink) {
        DrinksMap.add(drink.name, drink);
    }

    /*public void updateDrink(int n, Drink drink) {
        if (!DrinksList.getDrink(n).getName().equals(drink.name)) {
            DrinksMap.removeKey(drink.name);
        }
        DrinksMap.add(drink.name, drink);
        DrinksList.updateElement(n, drink);
    }*/

    public void deleteDrink(String key) {
        DrinksMap.removeKey(key);
    }



    public hashMap<String, Drink> getDrinksMap() {
        return DrinksMap;
    }

    public void setDrinksMap(hashMap<String, Drink> drinksMap) {
        DrinksMap = drinksMap;
    }

    @FXML
    public void addDrinkToList() {
        if (Sanitization.StringIsImageURL(imageURL.getText())) {
            linkedList<Ingredient> l = new linkedList<>();
            l.addElementH((Ingredient) ingredientList.getSelectionModel().getSelectedItem().getContent(), 0);
            Drink d = new Drink(name.getText(), origin.getText(), description.getText(), imageURL.getText(), l);
            addDrink(d);
        }
    }

    public void sortDrinkAlphabet(linkedList<Drink> listToSort) {
        shellSort.sortAlpha(listToSort);
    }

    public void sortDrinkABV(linkedList<Drink> listToSort) {
        shellSort.sortABV(listToSort);
    }

    public linkedList<Drink> searchName(String searchText) {
        linkedList<Drink> results = new linkedList<>();
        if (DrinksMap.get(searchText) != null) {
            results.addElementT(DrinksMap.get(searchText));
            return results;
        } else {
            return DrinksMap.keyContains(searchText);
        }
    }
}