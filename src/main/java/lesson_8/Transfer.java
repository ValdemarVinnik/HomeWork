package lesson_8;

import javax.swing.*;
import java.awt.*;

public class Transfer extends JFrame {
    String alphabet = "йцукенгшщзхъфывапролджэячсмитьбю.,";


    public Transfer() {
        setTitle("Рация шпиЁна");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);


        JTextField field = new JTextField();

        add(field, BorderLayout.NORTH);

        setLayout(new FlowLayout());

       // final JPanel
        for (String each: alphabet.split("")) {
            add(new JButton(each));

        }
        setVisible(true);
    }

    public static void main(String[] args) {


    }
}
