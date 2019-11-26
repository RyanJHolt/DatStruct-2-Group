package Controllers;

import Models.Ingredient;
import utils.linkedList;

public class IngredientController {

    linkedList<Ingredient> IngredientsList = new linkedList();

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
}
