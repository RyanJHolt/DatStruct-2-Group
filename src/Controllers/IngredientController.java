package Controllers;

import Models.Drink;
import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utils.Sanitization;
import utils.hashMap;
import utils.linkedList;
import utils.shellSort;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class IngredientController {

    public linkedList results = new linkedList();
    public static hashMap<String, Ingredient> IngredientsMap = new hashMap<>();
    @FXML
    ListView IngredientResults;
    @FXML
    TextField searchBox;
    @FXML
    TextField ingName;
    @FXML
    TextField ingDescription;
    @FXML
    TextField ingABV;

    public void addIngredient(Ingredient ingredient) {
        IngredientsMap.add(ingredient.name, ingredient);
    }

    public void deleteIngredient(String name) {
        IngredientsMap.removeKey(name);
    }

    public static hashMap<String, Ingredient> getIngredientsMap() {
        return IngredientsMap;
    }

    public static void setIngredientsMap(hashMap<String, Ingredient> ingredientsMap) {
        IngredientsMap = ingredientsMap;
    }

    @FXML
    public void addIngredientToIngredientList() {
        if (Sanitization.StringIsDouble(ingABV.getText())) {
            Ingredient ing = new Ingredient(ingName.getText(), ingDescription.getText(), Double.parseDouble(ingABV.getText()));
            addIngredient(ing);
            IngredientsMap.get(ingName.getText()).getDrinks().addElementH(ing);
            ingName.getScene().getWindow().hide();
        }
    }

    public linkedList<Ingredient> searchName(String searchText) {
        linkedList<Ingredient> results = new linkedList<>();
        if (IngredientsMap.get(searchText) != null) {
            results.addElementT(IngredientsMap.get(searchText));
            return results;
        } else {
            return IngredientsMap.keyContains(searchText);
            }
        }

    public void refreshSearchListView(){
        IngredientResults.getItems().clear();
        for (linkedList.linkedNode temp = results.getHead(); temp != null; temp = temp.next){
            IngredientResults.getItems().add(temp.getContents());
        }
    }

    public void ABVSort() {
        shellSort.sortABV(results);
        refreshSearchListView();
    }


    public void searchIngredients() {
        results = searchName(searchBox.getText());
        refreshSearchListView();
    }

    public void AlphabetSort() {
        shellSort.sortAlpha(results);
        refreshSearchListView();
    }
}
