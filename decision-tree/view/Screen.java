package decisiontree.view;

import decisiontree.control.Controller;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Screen extends JFrame {

    private final Controller owner;

    public Screen(Controller owner) {
        this.owner = owner;

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ButtonManager manager = new ButtonManager();
        JButton button1 = new JButton("Carregar último jogo");
        button1.addActionListener(manager);
        JButton button2 = new JButton("Começar novo jogo");
        button2.addActionListener(manager);
        JButton button3 = new JButton("Finalizar");
        button3.addActionListener(manager);

        gbc.gridx = 0;
        container.add(new JLabel("Árvore de Decisão"));
        container.add(button1, gbc);
        container.add(button2, gbc);
        container.add(button3, gbc);

        setSize(350, 300);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Carregar último jogo")) {
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Vamos jogar! Vou tentar adivinhar qual animal você está pensando, ok?", null, JOptionPane.PLAIN_MESSAGE);
                owner.handleOption(1);
            }
            if (ae.getActionCommand().equals("Começar novo jogo")) {
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Vamos jogar! Vou tentar adivinhar qual animal você está pensando, ok?", null, JOptionPane.PLAIN_MESSAGE);
                owner.handleOption(2);
            }
            if (ae.getActionCommand().equals("Finalizar")) {
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Obrigado por jogar! =)", null, JOptionPane.PLAIN_MESSAGE);
                owner.handleOption(0);
            }
        }
    }

    public void voidMessage(int option) {
        switch (option) {
            case 0:
                JOptionPane.showMessageDialog(null, "AHÁ! Estou bom nisso!");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Ok! Vou me recordar disso! =)", null, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Criando...", null, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Ei, você não respondeu a pergunta `.´", null, JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void exceptionMessage(Exception ex) {
        JOptionPane.showMessageDialog(null, ex, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public int intMessage(int option, String text) {
        Object[] options = {"Sim", "Não"};
        Object[] options2 = {"Não", "Sim", "Sim, novo jogo"};
        switch (option) {
            case 0:
                return JOptionPane.showOptionDialog(null, "O animal que você está pensando possui essa característica: " + text + "?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            case 1:
                return JOptionPane.showOptionDialog(null, "O animal que você está pensando é: " + text + "?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            case 2:
                return JOptionPane.showOptionDialog(null, "Jogar novamente? ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);                    
        }
        return 0;
    }
    
    public String stringMessage(int option, String animal, String text) {
        switch(option) {
            case 0:
                return JOptionPane.showInputDialog(null, "Awwn =(, qual animal estava pensando?", null, JOptionPane.QUESTION_MESSAGE);
            case 1:
                return JOptionPane.showInputDialog(null, "Qual um diferencial que é positivo para " + animal + " e negativo para " + text + "?", null, JOptionPane.QUESTION_MESSAGE);
                           
        }
        return "";
    }

}
