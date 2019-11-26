package Models;

public class Drink {
    public String drinkName;
    public String originPlace;
    public String description;
    public String picture;
    public double ABV;
    public Object Ingredients;
    public int ingredientQuantity;

    public Drink(String drinkName, String originPlace, String description, String picture, double ABV, Object ingredients, int quantity) {
        this.drinkName = drinkName;
        this.originPlace = originPlace;
        this.description = description;
        this.picture = picture;
        this.ABV = ABV;
        Ingredients = ingredients;
        this.ingredientQuantity = quantity;
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

    public double getABV() {
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
    }
}
