package Models;

//This class exists as a wrapper for an ingredient instance to
//provide extra necessary detail to a recipe without
//changing fields in the ingredient object itself,
//which is crucial for the ingredient search/CRUD
public class IngredientWrapper {

    Ingredient wrappedIngredient;
    float ml;

}
