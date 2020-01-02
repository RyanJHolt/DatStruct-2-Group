package utils;

import Controllers.DrinkController;
import Models.Drink;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IO {

    hashMap drinkMap = new hashMap();

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Database.xml"));
        drinkMap = (utils.hashMap) is.readObject();
        DrinkController.DrinksMap = drinkMap;
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Database.xml"));
        out.writeObject(DrinkController.DrinksMap);
        out.close();
    }
}
