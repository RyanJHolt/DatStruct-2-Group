package Controllers;

import Models.Drink;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import utils.linkedList;
import utils.shellSort;

public class searchDrinkController {

    public linkedList results = new linkedList();
    @FXML
    TextField searchBox;
    @FXML
    ListView DrinkResults;

    public linkedList<Drink> searchName(String searchText) {
        return DrinkController.DrinksMap.keyContains(searchText);
    }

    public void refreshSearchListView(){
        DrinkResults.getItems().clear();
        for (linkedList.linkedNode temp = results.getHead(); temp != null; temp = temp.next){
            DrinkResults.getItems().add(temp.getContents());
        }
    }

    public void ABVSort() {
        shellSort.sortABV(results);
        refreshSearchListView();
    }


    public void searchDrink() {
        results = searchName(searchBox.getText());
        refreshSearchListView();
    }

    public void AlphabetSort() {
        shellSort.sortAlpha(results);
        refreshSearchListView();
    }
}
