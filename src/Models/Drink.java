package Models;

import utils.linkedList;

public class Drink {
    public String drinkName;
    public String originPlace;
    public String description;
    public String picture;
    public double ABV;
    public linkedList recipe;
    public int totalQuantity = 0;

    public Drink(String drinkName, String originPlace, String description, String picture, linkedList recipe) {
        this.drinkName = drinkName;
        this.originPlace = originPlace;
        this.description = description;
        this.picture = picture;
        this.recipe = recipe;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int Totalquantity) {
        Totalquantity = Totalquantity;
    }

    public linkedList getRecipe() {
        return recipe;
    }

    public void setRecipe(linkedList recipe) {
        this.recipe = recipe;
    }

    private void calculateTotalQuantity(){
        int Quantity = 0;
        if (getTotalQuantity() == 0) {
            for (int i = 0; i < recipe.size(); i++) {
                Quantity += recipe.getElement(i).getQuantity();
            }
        } setTotalQuantity(Quantity);
    }

    private void calculateABV(){
        double ABV = 0;
        if (getTotalQuantity() == 0)
            calculateTotalQuantity();
        for (int i = 0; i < recipe.size(); i++){
            Ingredient temp = (Ingredient) recipe.getElement(i).getContents();
            int quantity = recipe.getElement(i).getQuantity();
            ABV += temp.getABV()*(quantity/ getTotalQuantity());
        }
        setABV(ABV);
    }

    public void addIngredient(Ingredient ingredient) {
        getRecipe().addElementH(ingredient);
    }

    public void updateIngredient(int n, Ingredient ingredient) {
        getRecipe().updateElement(n, ingredient);
    }

    public void deleteIngredient(int n) {
        getRecipe().deleteElement(n);
    }
}
