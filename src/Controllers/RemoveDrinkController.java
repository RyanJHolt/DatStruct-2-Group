package Controllers;

import Models.Drink;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import utils.hashMap;

public class RemoveDrinkController {

    @FXML
    ListView drink;

    @FXML
    void initialize() {
        drink.getItems().clear();
        drink.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if (!DrinkController.DrinksMap.isEmpty()) {
            for (hashMap.hashNode tempNode : DrinkController.DrinksMap.hashArray) {
                while (tempNode != null) {
                    drink.getItems().add(tempNode.getContent());
                    tempNode = tempNode.getNext();
                }
            }
        }
    }

    @FXML
    public void removeDrink() {
        Drink d = (Drink)drink.getSelectionModel().getSelectedItem();
        String dName = d.getName();
        DrinkController.deleteDrink(dName);
    }
}
