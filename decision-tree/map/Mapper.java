package decisiontree.map;

import decisiontree.control.Controller;
import decisiontree.model.Node;
import decisiontree.view.Screen;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mapper {
    private ArrayList<Node> cache; 
    private final String filename = "tree";
    private static Screen screen;
    
    public Mapper() {
        cache = new ArrayList<>();
        screen = new Screen(Controller.getInstance());
    }
    
    public void add(Node node) {
        cache.add(node);
    }
    
    public void clearCache() {
        cache = new ArrayList<>();
    }
    
    public void persist() {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            
            oout.writeObject(cache);
            
            oout.flush();
            fout.flush();
        } catch (FileNotFoundException ex) {
            screen.voidMessage(2);
        } catch (IOException ex) {
            screen.exceptionMessage(ex);
        }
    }
    
    public void load() {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);

            cache = (ArrayList<Node>) oi.readObject();

            oi.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            screen.voidMessage(2);
            persist();
        } catch (IOException | ClassNotFoundException ex) {
            screen.exceptionMessage(ex);
        }
    }

    public ArrayList<Node> getCache() {
        return cache;
    }

    public void setCache(ArrayList<Node> cache) {
        this.cache = cache;
    }    
}