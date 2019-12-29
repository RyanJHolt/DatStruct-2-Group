package Controllers;

import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import utils.linkedList;

public class IngredientController {

    @FXML
    TextField ingName;
    @FXML
    TextField ingDescription;
    @FXML
    TextField ingABV;

    public static linkedList<Ingredient> IngredientsList = new linkedList();

    public void addIngredient(Ingredient ingredient){
        IngredientsList.addElementH(ingredient);
    }

    public void updateIngredient(int n,Ingredient ingredient){
        IngredientsList.updateElement(n,ingredient);
    }

    public void deleteIngredient(int n){
        deleteIngredient(n);
    }

    public linkedList<Ingredient> getIngredientsList() {
        return IngredientsList;
    }

    public void setIngredientsList(linkedList<Ingredient> ingredientsList) {
        IngredientsList = ingredientsList;
    }

    @FXML
    public void addIngredientToDrinkList() {
        Ingredient ing = new Ingredient(ingName.getText(), ingDescription.getText(), Integer.parseInt(ingABV.getText()));
        addIngredient(ing);
    }
}
