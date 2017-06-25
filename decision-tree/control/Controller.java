package decisiontree.control;

import decisionTree.map.Mapper;
import decisiontree.model.Node;
import decisiontree.model.Tree;
import static java.lang.System.out;
import java.util.Scanner;

public final class Controller {

    private static Tree tree;
    private static Scanner keyboard;
    private static Mapper mapper;

    public static void initialize() {
        tree = new Tree();
        tree.setRoot(new Node("baleia"));
        keyboard = new Scanner(System.in);
        mapper = new Mapper();
        mapper.load();
        
        if (!mapper.getCache().isEmpty()) {
            tree.setRoot(mapper.getCache().get(0));
        }
    }

    public static void play() {
        out.println("------");
        out.println("Vamos jogar! Vou tentar adivinhar qual animal você está pensando, ok?");
        questionNode(tree.getRoot());
        out.println(mapper.getCache().toString());
    }

    public static void questionNode(Node node) {
        System.out.println();
        System.out.println("Me diga 'sim' ou 'nao':");

        if (node.getYes() != null) {
            out.println("O animal que você está pensando possui essa característica: " + node.getText() + "?");
            String input = keyboard.nextLine();
            switch (input.toLowerCase()) {
                case "sim":
                    questionNode(node.getYes());
                    break;
                case "nao":
                    questionNode(node.getNo());
                    break;
                default:
                    out.println("Digite apenas 'sim' ou 'nao'.");
                    questionNode(node);
                    break;
            }
        } else {
            System.out.println("O animal que você está pensando é: " + node.getText() + "?");
            String input = keyboard.nextLine();
            
            switch (input.toLowerCase()) {
                case "sim":
                    out.println("AHÁ! Estou bom nisso!");
                    play();
                    break;
                case "nao":
                    out.println("Awwn =(");
                    out.println("Qual animal estava pensando?");
                    String animal = keyboard.nextLine();
                    out.println("Qual um diferencial que é positivo para " + animal + " e negativo para " + node.getText() + "?");
                    String diferencial = keyboard.nextLine();
                    out.println("Ok! Vou me recordar disso! =)");
                    UpdateTree(node, animal, diferencial);
                    play();
                    break;
                default:
                    out.println("Digite apenas 'sim' ou 'nao'.");
                    questionNode(node);
                    break;
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
            out.println(root.getText());
            recursiveTraversal(root.getYes());
            recursiveTraversal(root.getNo());
        }
    }
}
