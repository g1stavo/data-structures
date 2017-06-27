package decisiontree.control;

import decisionTree.map.Mapper;
import decisiontree.model.Node;
import decisiontree.model.Tree;
import decisiontree.view.Screen;
import java.util.Scanner;
import javax.swing.JOptionPane;

public final class Controller {

    private static Tree tree;
    private static Scanner keyboard;
    private static Mapper mapper;
    private static Controller instance = null;
    private static Screen screen;

    public Controller() {
        screen = new Screen(this);
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public static void initialize() {
        tree = new Tree();
        tree.setRoot(new Node("baleia"));
        keyboard = new Scanner(System.in);
        mapper = new Mapper();
        mapper.load();

        if (!mapper.getCache().isEmpty()) {
            tree.setRoot(mapper.getCache().get(0));
        }

        screen.setVisible(true);
    }

    public static void handleOption(int option) {
        switch (option) {
            case 0:                
                System.exit(0);
            case 1:                
                questionNode(tree.getRoot());
            case 2:
                tree = new Tree();
                tree.setRoot(new Node("baleia"));
                questionNode(tree.getRoot());
        }
    }

    public static void questionNode(Node node) {

        if (node.getYes() != null) {
            Object[] options = {"Sim", "Não"};
            int option = JOptionPane.showOptionDialog(null, "O animal que você está pensando possui essa característica: " + node.getText() + "?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    questionNode(node.getYes());
                    break;
                case 1:
                    questionNode(node.getNo());
                    break;
            }

        } else {
            Object[] options = {"Sim", "Não"};
            int option = JOptionPane.showOptionDialog(null, "O animal que você está pensando é: " + node.getText() + "?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, "AHÁ! Estou bom nisso!");

                    Object[] options2 = {"Não", "Sim", "Sim, novo jogo"};
                    int option2 = JOptionPane.showOptionDialog(null, "Jogar novamente? ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
                    handleOption(option2);
                case 1:
                    String animal = null;
                    try {
                        while (animal == null || animal.equals("")) {
                            animal = JOptionPane.showInputDialog(null, "Awwn =(, qual animal estava pensando?", null, JOptionPane.QUESTION_MESSAGE);
                            if (animal.equals("")) {
                                JOptionPane.showMessageDialog(null, "Ei, você não respondeu a pergunta `.´", null, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception e) {
                        System.exit(0);
                    }

                    String diferencial = null;
                    try {
                        while (diferencial == null || diferencial.equals("")) {
                            diferencial = JOptionPane.showInputDialog(null, "Qual um diferencial que é positivo para " + animal + " e negativo para " + node.getText() + "?", null, JOptionPane.QUESTION_MESSAGE);
                            if (diferencial.equals("")) {
                                JOptionPane.showMessageDialog(null, "Ei, você não respondeu a pergunta `.´", null, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception e) {
                        System.exit(0);
                    }

                    JOptionPane.showMessageDialog(null, "Ok! Vou me recordar disso! =)", null, JOptionPane.INFORMATION_MESSAGE);
                    UpdateTree(node, animal, diferencial);
                    screen.setVisible(true);
            }
        }
    }

    public static void UpdateTree(Node node, String newAnimal, String diferential) {
        String oldAnimal = node.getText();
        node.setText(diferential);
        node.setYes(new Node(newAnimal));
        node.setNo(new Node(oldAnimal));
        mapper.clearCache();
        traversal();
        mapper.persist();
    }

    public static void traversal() {
        Node root = tree.getRoot();
        recursiveTraversal(root);
    }

    public static void recursiveTraversal(Node root) {
        if (root != null) {
            mapper.add(root);
            recursiveTraversal(root.getYes());
            recursiveTraversal(root.getNo());
        }
    }
}
