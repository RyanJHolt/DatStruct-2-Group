package Controllers;

import Models.Recipe;
import utils.linkedList;

public class RecipeController {

    linkedList<Recipe> RecipesList = new linkedList();

    public void addRecipe(Recipe recipe){
        RecipesList.addElementH(recipe);
    }

    public void updateRecipe(int n,Recipe recipe){
        RecipesList.updateElement(n,recipe);
    }

    public void deleteRecipe(int n){
        deleteRecipe(n);
    }

    public linkedList<Recipe> getRecipesList() {
        return RecipesList;
    }

    public void setRecipesList(linkedList<Recipe> recipesList) {
        RecipesList = recipesList;
    }
}
