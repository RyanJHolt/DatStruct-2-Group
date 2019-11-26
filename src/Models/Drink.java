package Models;

public class Drink {
    public String drinkName;
    public String originPlace;
    public String description;
    public String picture;
    public double ABV;
    public Object Ingredients;
    public int quantity;

    public Drink(String drinkName, String originPlace, String description, String picture, double ABV, Object ingredients, int quantity) {
        this.drinkName = drinkName;
        this.originPlace = originPlace;
        this.description = description;
        this.picture = picture;
        this.ABV = ABV;
        Ingredients = ingredients;
        this.quantity = quantity;
    }
}
