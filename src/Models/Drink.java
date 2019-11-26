package Models;

public class Drink {
    public String drinkName;
    public String originPlace;
    public String description;
    public String picture;
    public Recipe Recipe;

    public Drink(String drinkName, String originPlace, String description, String picture, double ABV, Recipe Recipe, int quantity) {
        this.drinkName = drinkName;
        this.originPlace = originPlace;
        this.description = description;
        this.picture = picture;
        this.Recipe = Recipe;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /* public double getABV() {
        return Recipe.getABV();
    }

    public void setABV(double ABV) {
        Recipe.setABV(ABV);
    }

    public Object getIngredients() {
        return Recipe.getIngredients();
    }

    public void setIngredients(Object ingredients) {
        Ingredients = ingredients;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }*/
}
