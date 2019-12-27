package utils;

import java.io.*;

import Models.Drink;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class IO {

    utils.linkedList<Drink> drinkList;

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Database.xml"));
        drinkList = (utils.linkedList<Drink>) is.readObject();
        Main.drinkList = drinkList;
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Database.xml"));
        out.writeObject(Main.drinkList);
        out.close();
    }
}
