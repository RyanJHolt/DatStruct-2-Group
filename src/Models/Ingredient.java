package Models;

@SuppressWarnings("unused")
public class Ingredient {

    public String name;
    public String description;
    public double ABV;

    public Ingredient(String name, String description, double ABV) {
        this.name = name;
        this.description = description;
        this.ABV = ABV;
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
}
