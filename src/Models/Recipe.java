package Models;

import utils.linkedList;

public class Recipe {
    public String drinkName;
    public double ABV;
    public linkedList ingredientQuantity;

    linkedList<Ingredient> ingredients = new linkedList();

    public Recipe(String drinkName, double ABV, linkedList ingredients, linkedList
            ingredientQuantity) {
        this.drinkName = drinkName;
        this.ABV = ABV;
        this.ingredientQuantity = ingredientQuantity;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

 /*   public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    public Object getIngredients() {
        return Ingredients;
    }

    public void setIngredients(Object ingredients) {
        Ingredients = ingredients;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    } */
}
