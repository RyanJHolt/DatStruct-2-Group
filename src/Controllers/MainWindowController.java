package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.IO;

public class MainWindowController {

    @FXML
    void AddDrinkWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/AddDrink.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Add A Drink");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void AddIngredientWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/AddIngredient.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Add An Ingredient");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void RemoveIngredientWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/RemoveIngredient.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Remove An Ingredient");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void RemoveDrinkWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/RemoveDrink.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Remove A Drink");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SearchDrinksWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/SearchDrinks.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Search Drinks");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SearchIngredientsWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/SearchIngredients.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Search Ingredients");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void DatabaseWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/Database.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("View All");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void LoadData() {
        try {
            IO input = new IO();
            input.load();
            System.out.println("Loaded successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SaveData() {
        try {
            IO output = new IO();
            output.save();
            System.out.println("Saved successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void ResetData() {
        DrinkController.DrinksList.clear();
        System.out.println("All data cleared! Load to restore, or Save to clear permanently.");
    }
}
