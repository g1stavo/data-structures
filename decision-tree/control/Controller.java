package decisiontree.control;

import decisiontree.map.Mapper;
import decisiontree.model.Node;
import decisiontree.model.Tree;
import decisiontree.view.Screen;

public final class Controller {
    private static Tree tree;
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
            switch (screen.intMessage(0, node.getText())) {
                case 0:
                    questionNode(node.getYes());
                    break;
                case 1:
                    questionNode(node.getNo());
                    break;
            }
        } else {
            switch (screen.intMessage(1, node.getText())) {
                case 0:
                    screen.voidMessage(0);
                    handleOption(screen.intMessage(2, null));
                case 1:
                    String animal = null;
                    try {
                        while (animal == null || animal.equals("")) {
                            animal = screen.stringMessage(0, null, null);
                            if (animal.equals("")) {
                                screen.voidMessage(3);
                            }
                        }
                    } catch (Exception e) {
                        System.exit(0);
                    }

                    String diferencial = null;
                    try {
                        while (diferencial == null || diferencial.equals("")) {
                            diferencial = screen.stringMessage(1, animal, node.getText());
                            if (diferencial.equals("")) {
                                screen.voidMessage(3);
                            }
                        }
                    } catch (Exception e) {
                        System.exit(0);
                    }

                    screen.voidMessage(1);
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
