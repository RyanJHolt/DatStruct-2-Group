package Controllers;

import Models.Drink;
import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utils.hashMap;
import utils.linkedList;
import utils.shellSort;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class DatabaseController {
    hashMap Drinks = DrinkController.getDrinksMap();
    hashMap Ingredients = IngredientController.getIngredientsMap();
    public linkedList results = new linkedList();

    @FXML
    ListView Results;
    @FXML
    TextField searchBox;
    @FXML
    ListView DrinkList;
    @FXML
    ListView IngredientList;

    void initialize(){
        IngredientList.getItems().clear();
        if (!Drinks.isEmpty()){
            for (hashMap.hashNode temp : Drinks.hashArray){
                while (temp != null){
                    DrinkList.getItems().add(temp.getContent());
                    temp = temp.getNext();
                }
            }
        }
        if (!Ingredients.isEmpty()){
            for (hashMap.hashNode temp : Ingredients.hashArray){
                while (temp != null){
                    IngredientList.getItems().add(temp.getContent());
                    temp = temp.getNext();
                }
            }
        }
    }

    public void getDrinks() {
        Drink drink = (Drink) DrinkList.getSelectionModel().getSelectedItem();
        IngredientList.getItems().clear();
        for (linkedList.linkedNode temp = drink.getRecipe().getHead();temp != null; temp = temp.next){
            IngredientList.getItems().add(temp.getContents());
        }
    }

    public void getIngredients() {
        Ingredient ingredient = (Ingredient) DrinkList.getSelectionModel().getSelectedItem();
        DrinkList.getItems().clear();
        for (linkedList.linkedNode temp = ingredient.getDrinks().getHead(); temp != null; temp = temp.next){
            DrinkList.getItems().add(temp.getContents());
        }
    }

    public linkedList searchName(String searchText) {
        linkedList result = DrinkController.DrinksMap.keyContains(searchText);
        linkedList tempList = IngredientController.getIngredientsMap().keyContains(searchText);
        for (linkedList.linkedNode temp = tempList.getHead(); temp != null; temp = temp.next){
            result.addElementH(temp.getContents());
        } return result;
    }

    public void refreshSearchListView(){
        Results.getItems().clear();
        for (linkedList.linkedNode temp = results.getHead(); temp != null; temp = temp.next){
            Results.getItems().add(temp.getContents());
        }
    }

    public void ABVSort() {
        shellSort.sortABV(results);
        refreshSearchListView();
    }


    public void searchAll() {
        results = searchName(searchBox.getText());
        refreshSearchListView();
    }

    public void AlphabetSort() {
        shellSort.sortAlpha(results);
        refreshSearchListView();
    }
}
