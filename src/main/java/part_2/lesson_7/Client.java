package part_2.lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final int PORT = 8888;
    private final String LOCAL_HOST = "127.0.0.1";

    private String message;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean connectionIsAlive;
    private Scanner scanner;


    public Client() {
        this.scanner = new Scanner(System.in);
    }

    private void start() {

        try {
            openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }

        getThreadReader().start();
        getThreadWriter().start();

        while (connectionIsAlive) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessage(String serversMessage) throws IOException {
        out.writeUTF(serversMessage);
    }

    private String readMessage() throws IOException {
        String message =  in.readUTF();
        printToConsole(message);
        return  message;
    }

    private void openConnection() throws IOException {

        socket = new Socket(LOCAL_HOST, PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        connectionIsAlive = true;
    }

    private void closeConnection() {

        connectionIsAlive = false;
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

        }
    }

    private Thread getThreadWriter() {
        Thread threadWriter = new Thread() {
            @Override
            public void run() {

                do {
                    String clientMessage = scanner.nextLine();
                    try {
                        sendMessage(clientMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }while (connectionIsAlive);
            }
        };

        threadWriter.setDaemon(true);
        return threadWriter;
    }

    private Thread getThreadReader() {
        Thread threadReader = new Thread() {
            @Override
            public void run() {

                try {
                    while (connectionIsAlive) {

                        message = readMessage();

                        if ("/end".equalsIgnoreCase(message)) {
                            sendMessage(message);
                            closeConnection();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }
        };

        threadReader.setDaemon(true);
        return threadReader;
    }

    private void printToConsole(String message) {
        System.out.printf("[server] <- %s \n", message);
    }

    public static void main(String[] args) {
        new Client().start();
    }

}
