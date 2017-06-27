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
    

}
