package lesson_8;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextConverter {

    public final Sound sound = new Sound(new File("src/main/java/lesson_8/ton.wav"));

    private Map<String, String> letters;
    private String morse;

    public TextConverter() {
        setMap();
    }

    private void setMap() {
        letters = new HashMap<>();
        letters.put("а", "*-");
        letters.put("б", "-***");
        letters.put("в", "*--");
        letters.put("г", "--*");
        letters.put("д", "-**");
        letters.put("е", "*");
        letters.put("ж", "***-");
        letters.put("з", "--**");
        letters.put("и", "**");
        letters.put("й", "*---");
        letters.put("к", "-*-");
        letters.put("л", "*-**");
        letters.put("м", "--");
        letters.put("н", "-*");
        letters.put("о", "---");
        letters.put("п", "*--*");
        letters.put("р", "*-*");
        letters.put("с", "***");
        letters.put("т", "-");
        letters.put("у", "**-");
        letters.put("ф", "**-*");
        letters.put("х", "****");
        letters.put("ц", "-*-*");
        letters.put("ч", "---*");
        letters.put("ш", "----");
        letters.put("щ", "--*-");
        letters.put("ъ", "-*--");
        letters.put("ь", "-*--");
        letters.put("э", "**-**");
        letters.put("ю", "**--");
        letters.put("я", "*-*-");
        letters.put("ы", "-*--");
        letters.put(".", "******");
        letters.put(",", "*-*-*-");
        letters.put(" ", " ");
    }

    public void setText(String text) throws InterruptedException {
        morse = null;
        StringBuilder builder = new StringBuilder();
        for (String letter : text.toLowerCase().split("")) {
            builder.append(letters.get(letter) + " ");
        }
        morse = builder.toString();
        playMassage();
    }

    private void playDot() throws InterruptedException {
        sound.play();
        Thread.sleep(300);
        sound.stop();
        Thread.sleep(5);
    }

    private void playDash() throws InterruptedException {
        sound.play();
        Thread.sleep(550);
        sound.stop();
        Thread.sleep(5);
    }


    public void printMorse() {
        System.out.println(morse);
    }

    private void playMassage() throws InterruptedException {

        for (String each : morse.trim().split("")) {

            switch (each) {
                case "*":
                    playDot();
                    break;
                case "-":
                    playDash();
                    break;
                case " ":
                    Thread.sleep(400);
            }
        }
    }
}
