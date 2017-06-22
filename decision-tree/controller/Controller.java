package decisionTree.control;

import decisionTree.model.Node;
import decisionTree.model.Tree;
import decisionTree.view.Screen;
import static java.lang.System.out;

public class Controller {
    
    public Screen screen;
    public Tree tree;
    
    public Controller() {
        screen = new Screen(this);
        tree = new Tree();
    }    

    public Tree getTree() {
        return tree;
    }
    
    public void start() {
        screen.showMenu();
    }
    
    public void handleOption(int option) {
        switch (option) {
            case 0:
                out.println("Finalizando...");
                break;
            case 1:
                screen.play();
                break;
            case 2:
                screen.load();
                break;            
            default:
                out.println("Opção inválida");
                break;
        }
    }

    public void updateTree(String animal, String difference) {
        String aux = tree.getRoot().getText();
        tree.setRoot(new Node(difference));
        tree.getRoot().setYes(new Node(animal));
        tree.getRoot().setNo(new Node(aux));
    }
    
    
}