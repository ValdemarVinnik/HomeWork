package part_2.lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    String message;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public static void main(String[] args) {
        new Client().start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        try {
            openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!("/end".equalsIgnoreCase(message))) {

            sendMessage(scanner.nextLine());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1", 8888);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

         new Thread() {
            @Override
            public void run() {

                try {
                    do {
                        message = in.readUTF();
                        System.out.println("Сообщение от сервера: " + message);
                    } while (!"/end".equalsIgnoreCase(message));

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }


            }
        }.start();


    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

           // Runtime.getRuntime().exit(0);
        }
    }

}
