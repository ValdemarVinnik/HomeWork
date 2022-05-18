package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transfer extends JFrame {
    private JLabel firstDisplay;
    String alphabet = "йцукенгшщзхъфывапролджэячсмитьбю.,";

   ActionListener letterListener = new ActionListener(){

       @Override
       public void actionPerformed(ActionEvent actionEvent) {
           JButton button = (JButton) actionEvent.getSource();
           String message = firstDisplay.getText();
            message += button.getText();
            firstDisplay.setText(message);
       }
   };

    public Transfer() {
        setTitle("Рация шпиЁна");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,1));
        firstDisplay = new JLabel("->");
        firstDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        firstDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel secondDisplay = new JLabel("<-");
        secondDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        secondDisplay.setFont(new Font("Arial", Font.BOLD, 20));
       jPanel.add(firstDisplay);
        jPanel.add(secondDisplay);

        add(jPanel,BorderLayout.NORTH);
        add(setLetters(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JPanel setLetters(){

        final JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new FlowLayout());
        for (String each: alphabet.split("")) {
            JButton button = new JButton(each);
            button.addActionListener(letterListener);
            lettersPanel.add(button);
        }
        lettersPanel.add(new Button("space"));
        return  lettersPanel;
    }

    public static void main(String[] args) {
new Transfer();

    }
}
