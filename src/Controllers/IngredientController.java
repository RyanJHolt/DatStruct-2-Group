package Controllers;

import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import utils.hashMap;
import utils.linkedList;
import utils.shellSort;

public class IngredientController {

    @FXML
    TextField ingName;
    @FXML
    TextField ingDescription;
    @FXML
    TextField ingABV;

    public static linkedList<Ingredient> IngredientsList = new linkedList();
    public static hashMap<String,Ingredient> IngredientMap = new hashMap<>();

    public void addIngredient(Ingredient ingredient){
        IngredientsList.addElementH(ingredient);
    }

    public void updateIngredient(int n,Ingredient ingredient){
        IngredientsList.updateElement(n,ingredient);
        IngredientMap.add(ingredient.name,ingredient);
    }

    public void deleteIngredient(int n){
        String temp = IngredientsList.getIngredient(n).getName();
        IngredientsList.deleteElement(n);
        IngredientMap.removeKey(temp);
    }

    public linkedList<Ingredient> getIngredientsList() {
        return IngredientsList;
    }

    public void setIngredientsList(linkedList<Ingredient> ingredientsList) {
        IngredientsList = ingredientsList;
    }

    public static hashMap<String, Ingredient> getIngredientMap() {
        return IngredientMap;
    }

    public static void setIngredientMap(hashMap<String, Ingredient> ingredientMap) {
        IngredientMap = ingredientMap;
    }

    @FXML
    public void addIngredientToDrinkList() {
        Ingredient ing = new Ingredient(ingName.getText(), ingDescription.getText(), Integer.parseInt(ingABV.getText()));
        addIngredient(ing);
    }

    public void sortIngredientAlphabet(){
        shellSort.sortAlpha(IngredientsList);
    }

    public void sortIngredientABV(){
        shellSort.sortABV(IngredientsList);
    }
}
