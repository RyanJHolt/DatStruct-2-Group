package Controllers;

import Models.Drink;
import Models.Ingredient;
import javafx.event.ActionEvent;
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

    public static hashMap<String, Drink> DrinksMap = new hashMap<>();
    public linkedList results = new linkedList();
    @FXML
    TextField searchBox;
    @FXML
    ListView DrinkResults;
    @FXML
    TextField name;
    @FXML
    TextField origin;
    @FXML
    TextField imageURL;
    @FXML
    TextArea description;
    @FXML
    ListView ingredientList;

    @FXML
    void initialize() {
        ingredientList.getItems().clear();
        ingredientList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if (!IngredientController.getIngredientsMap().isEmpty()) {
            for (hashMap.hashNode tempNode : IngredientController.getIngredientsMap().hashArray) {
                while (tempNode != null) {
                    ingredientList.getItems().add(tempNode.getContent());
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
            linkedList<Ingredient> ingredients = new linkedList<>();
            hashMap.hashNode tempNode = (hashMap.hashNode) ingredientList.getSelectionModel().getSelectedItem();
            Ingredient temp = (Ingredient) tempNode.getContent();
            ingredients.addElementH(temp, 0);
            Drink d = new Drink(name.getText(), origin.getText(), description.getText(), imageURL.getText(), ingredients);
            addDrink(d);
            IngredientController.getIngredientsMap().get(temp.getName()).getDrinks().addElementT(d);
            imageURL.getScene().getWindow().hide();
        }
    }

    public linkedList<Drink> searchName(String searchText) {
        return DrinksMap.keyContains(searchText);
    }

    public void refreshSearchListView(){
        DrinkResults.getItems().clear();
        for (linkedList.linkedNode temp = results.getHead(); temp != null; temp = temp.next){
            DrinkResults.getItems().add(temp.getContents());
        }
    }

    public void ABVSort() {
        shellSort.sortABV(results);
        refreshSearchListView();
    }


    public void searchDrink() {
        results = searchName(searchBox.getText());
        refreshSearchListView();
    }

    public void AlphabetSort() {
        shellSort.sortAlpha(results);
        refreshSearchListView();
    }
}