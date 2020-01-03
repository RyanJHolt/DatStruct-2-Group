package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import utils.hashMap;

public class RemoveIngredientController {

    @FXML
    ListView ing;

    @FXML
    void initialize() {
        ing.getItems().clear();
        ing.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if (!IngredientController.getIngredientsMap().isEmpty()) {
            for (hashMap.hashNode tempNode : IngredientController.getIngredientsMap().hashArray) {
                while (tempNode != null) {
                    ing.getItems().add(tempNode.getContent());
                    tempNode = tempNode.getNext();
                }
            }
        }
    }
}
