package decisionTree.map;

import decisiontree.model.Node;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * 
 * @author Gustavo de Castro Salvador <gustavocsalvador at gmail.com>
 */
public class Mapper {
    
    private ArrayList<Node> cache; 
    private final String filename = "tree";
    
    public Mapper() {
        cache = new ArrayList<>();
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
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado. Criando...", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, null, JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado. Criando...", null, JOptionPane.INFORMATION_MESSAGE);
            persist();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ArrayList<Node> getCache() {
        return cache;
    }

    public void setCache(ArrayList<Node> cache) {
        this.cache = cache;
    }    
    
}