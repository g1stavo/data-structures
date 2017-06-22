package decisionTree.view;

import decisionTree.control.Controller;
import static java.lang.System.out;
import java.util.Scanner;

public class Screen {
    
    private final Controller owner;
    private final Scanner keyboard;
    private String answer;
    
    public Screen(Controller owner) {
        this.owner = owner;
        this.keyboard = new Scanner(System.in);
    }
    
    public void showMenu() {        
        int option = 0;
        do {
            out.println("-----------------------------------");
            out.println("---------Árvore de Decisão---------");
            out.println("1.--------------Jogar--------------");
            out.println("2.-------Carregar último jogo------");
            out.println("0.------------Finalizar------------");
            out.println("-----------------------------------");

            option = Integer.parseInt(keyboard.nextLine());
            owner.handleOption(option);
        } while (option != 0);       
        
    }   
    
    public void play() {
        out.println("Pense em um animal!");
        out.println("O seu animal é " + owner.getTree().getRoot().getText() + "?");   
        answer = keyboard.nextLine();
        handleAnswer(answer);
    }
    
    public void handleAnswer(String answer) {
        if (answer.equals("sim")) {
            out.println("Boa! Viu como estou aprendendo? =)");
        } else if (answer.equals("não")) {
            out.println("Em que animal pensastes?");
            String animal = keyboard.nextLine();
            out.println("O que diferencia " + animal + " de " + owner.getTree().getRoot().getText() + "?");
            String difference = keyboard.nextLine();
            out.println("Valeu! Ainda estou aprendendo... =(");
            owner.updateTree(animal, difference);
        } else {
            out.println("Responda com 'sim' ou não!");
            play();
        }
    }
    
    public void load() {
        
    }        
    
}