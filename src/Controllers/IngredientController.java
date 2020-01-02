package Controllers;

import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import utils.*;

@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class IngredientController {

    //public static linkedList<Ingredient> IngredientsList = new linkedList();
    public static hashMap<String, Ingredient> IngredientsMap = new hashMap<>();
    @FXML
    TextField ingName;
    @FXML
    TextField ingDescription;
    @FXML
    TextField ingABV;

    public static hashMap<String, Ingredient> getIngredientMap() {
        return IngredientsMap;
    }

    public static void setIngredientMap(hashMap<String, Ingredient> ingredientMap) {
        IngredientsMap = ingredientMap;
    }

    public void addIngredient(Ingredient ingredient) {
        IngredientsMap.add(ingredient.name, ingredient);
    }


    public void deleteIngredient(String name) {
        IngredientsMap.removeKey(name);
    }

    public static hashMap<String, Ingredient> getIngredientsMap() {
        return IngredientsMap;
    }

    public static void setIngredientsMap(hashMap<String, Ingredient> ingredientsMap) {
        IngredientsMap = ingredientsMap;
    }

    @FXML
    public void addIngredientToIngredientList() {
        if (Sanitization.StringIsDouble(ingABV.getText())) {
            Ingredient ing = new Ingredient(ingName.getText(), ingDescription.getText(), Integer.parseInt(ingABV.getText()));
            addIngredient(ing);
        }
    }

    /*public void sortIngredientAlphabet() {
        shellSort.sortAlpha(IngredientsList);
    }

    public void sortIngredientABV() {
        shellSort.sortABV(IngredientsList);
    }*/

    public linkedList<Ingredient> searchName(String searchText) {
        linkedList<Ingredient> results = new linkedList<>();
        if (IngredientsMap.get(searchText) != null) {
            results.addElementT(IngredientsMap.get(searchText));
            return results;
        } else {
            return IngredientsMap.keyContains(searchText);
            }
        }
    }
