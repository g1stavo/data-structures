package decisiontree.control;

import decisiontree.model.Node;
import decisiontree.model.Tree;
import static java.lang.System.out;
import java.util.Scanner;

public final class Controller {

    private static Tree tree;
    private static Scanner keyboard;

    public static void Initialize() {
        tree = new Tree();
        tree.setRoot(new Node("Baleia"));
        keyboard = new Scanner(System.in);
    }

    public static void Play() {
        out.println("------");
        out.println("Vamos jogar! Vou tentar advinhar qual animal você está pensando, ok?");
        QuestionaNode(tree.getRoot());
    }

    public static void QuestionaNode(Node node) {
        System.out.println();
        System.out.println("Me diga 'sim' ou 'nao':");

        //Possui galhos - é uma pergunta.
        if (node.getYes() != null) {
            out.println("O animal que você está pensando possui essa caracteristica: " + node.getText() + "?");
            String input = keyboard.nextLine();
            if (input.toLowerCase().equals("sim")) {
                QuestionaNode(node.getYes());
            } else if (input.toLowerCase().equals("nao")) {
                QuestionaNode(node.getNo());
            } else {
                out.println("Digite apenas 'sim' ou 'nao'.");
                QuestionaNode(node);
            }
        } //Não possui galhos - é uma folha - é um animal.
        else {
            System.out.println("O animal que você está pensando é: " + node.getText() + "?");
            String input = keyboard.nextLine();
            if (input.toLowerCase().equals("sim")) {
                out.println("AHÁ! Estou bom nisso!");
                Play();
            } else if (input.toLowerCase().equals("nao")) {
                out.println("Awwn =(");
                out.println("Qual animal estava pensando?");
                String animal = keyboard.nextLine();
                out.println("Qual um diferencial que é positivo para " + animal + " e negativo para " + node.getText() + "?");
                String diferencial = keyboard.nextLine();
                out.println("Ok! Vou me recordar disso! =)");
                UpdateTree(node, animal, diferencial);
                Play();
            } else {
                out.println("Digite apenas 'sim' ou 'nao'.");
                QuestionaNode(node);
            }
        }
    }

    public static void UpdateTree(Node node, String novoAnimal, String diferencial) {
        String velhoAnimal = node.getText();
        node.setText(diferencial);
        node.setYes(new Node(novoAnimal));
        node.setNo(new Node(velhoAnimal));
    }

}