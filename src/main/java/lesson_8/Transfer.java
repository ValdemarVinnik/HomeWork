package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class Transfer extends JFrame {
    private TextConverter textConverter;

    private JLabel firstDisplay;
    String alphabet = "йцукенгшщзхъфывапролджэячсмитьбю.,";

    ActionListener letterListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton button = (JButton) actionEvent.getSource();
            String message = firstDisplay.getText();
            message += button.getText();
            firstDisplay.setText(message);
        }
    };
    ActionListener spaceListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton button = (JButton) actionEvent.getSource();
            String message = firstDisplay.getText();
            message += " ";
            firstDisplay.setText(message);
        }
    };

    ActionListener backspaceListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton button = (JButton) actionEvent.getSource();
            String message = firstDisplay.getText();
            message = message.substring(0, message.length() - 1);
            firstDisplay.setText(message);
        }
    };
    ActionListener sendButtonListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton button = (JButton) actionEvent.getSource();
            String message = firstDisplay.getText();
            try {
                textConverter.setText(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public Transfer(TextConverter textConverter) {
        this.textConverter = textConverter;

        setTitle("Рация шпиЁна");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 1));
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

        JButton sendButton = new JButton("ОТПРАВИТЬ В КРЕМЛЬ");
        sendButton.addActionListener(sendButtonListener);
        add(sendButton, BorderLayout.SOUTH);


        setVisible(true);
    }

    private JPanel setLetters() {

        final JPanel lettersPanel = new JPanel();
        lettersPanel.setLayout(new FlowLayout());
        for (String each : alphabet.split("")) {
            JButton button = new JButton(each);
            button.addActionListener(letterListener);
            lettersPanel.add(button);
        }
        JButton spaceButton = new JButton("space");
        spaceButton.addActionListener(spaceListener);
        lettersPanel.add(spaceButton);

        JButton backspaceButton = new JButton("<-");
        backspaceButton.addActionListener(backspaceListener);
        lettersPanel.add(backspaceButton);
        return lettersPanel;
    }

    public static void main(String[] args) throws MalformedURLException {
new Transfer(new TextConverter());

    }
}
