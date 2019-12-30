package Controllers;

import Models.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import utils.comparator;
import utils.hashMap;
import utils.linkedList;
import utils.shellSort;

@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class IngredientController {

    @FXML
    TextField ingName;
    @FXML
    TextField ingDescription;
    @FXML
    TextField ingABV;

    public static linkedList<Ingredient> IngredientsList = new linkedList();
    public static hashMap<String,Ingredient> IngredientsMap = new hashMap<>();

    public void addIngredient(Ingredient ingredient){
        IngredientsList.addElementH(ingredient);
        IngredientsMap.add(ingredient.name,ingredient);
    }

    public void updateIngredient(int n,Ingredient ingredient){
        if (!IngredientsList.getIngredient(n).getName().equals(ingredient.name)){
            IngredientsMap.removeKey(ingredient.name);
        } IngredientsMap.add(ingredient.name,ingredient);
        IngredientsList.updateElement(n, ingredient);
    }

    public void deleteIngredient(int n){
        String temp = IngredientsList.getIngredient(n).getName();
        IngredientsList.deleteElement(n);
        IngredientsMap.removeKey(temp);
    }

    public linkedList<Ingredient> getIngredientsList() {
        return IngredientsList;
    }

    public void setIngredientsList(linkedList<Ingredient> ingredientsList) {
        IngredientsList = ingredientsList;
    }

    public static hashMap<String, Ingredient> getIngredientMap() {
        return IngredientsMap;
    }

    public static void setIngredientMap(hashMap<String, Ingredient> ingredientMap) {
        IngredientsMap = ingredientMap;
    }

    @FXML
    public void addIngredientToIngredientList() {
        Ingredient ing = new Ingredient(ingName.getText(), ingDescription.getText(), Integer.parseInt(ingABV.getText()));
        addIngredient(ing);
    }

    public void sortIngredientAlphabet(){
        shellSort.sortAlpha(IngredientsList);
    }

    public void sortIngredientABV(){
        shellSort.sortABV(IngredientsList);
    }

    public linkedList<Ingredient> searchName(String searchText){
        linkedList<Ingredient> results = new linkedList<>();
        if (IngredientsMap.get(searchText) != null){
            results.addElementT(IngredientsMap.get(searchText));
        } else {
            for (linkedList.linkedNode head = IngredientsList.getHead(); head != null; head = head.next ){
                if (comparator.Contains(head,searchText)){
                    results.addElementT((Ingredient) head.getContents());
                }
            }
        }
        return results;
    }
}
