package Models;

import utils.linkedList;

@SuppressWarnings({"unused", "rawtypes", "unchecked"})
public class Ingredient {

    public String name;
    public String description;
    public double ABV;
    public linkedList Drinks;

    public Ingredient(String name, String description, double ABV) {
        this.name = name;
        this.description = description;
        this.ABV = ABV;
        Drinks = new linkedList();
    }

    public boolean contains(String compare) {
        compare = compare.toUpperCase();
        return getName().toUpperCase().contains(compare);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    public linkedList getDrinks() {
        return Drinks;
    }

    public void setDrinks(linkedList drinks) {
        Drinks = drinks;
    }

    public void addDrink(Drink drink){
        Drinks.addElementH(drink);
    }

    public void removeDrink(int index){
        Drinks.deleteElement(index);
    }

    public void editDrink(int index,Drink drink){
        Drinks.updateElement(index,drink);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", ABV=" + ABV +
                '}';
    }
}

