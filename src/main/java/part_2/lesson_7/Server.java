package part_2.lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private final int PORT = 8888;

    private String message;
    private DataOutputStream out;
    private DataInputStream in;
    private Socket socket;
    private Scanner scanner;
    private boolean connectionIsAlive;

    public Server() {
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
        String message = in.readUTF();
        printToConsole(message);
        return message;
    }

    private void openConnection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("-> Server is waiting connection.....");
        Socket socket = serverSocket.accept();
        System.out.println("-> client connected.");

        connectionIsAlive = true;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
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

    private Thread getThreadReader() {
        Thread threadReader = new Thread() {
            @Override
            public void run() {

                try {
                    while (connectionIsAlive) {

                        message = readMessage();

                        if ("/end".equalsIgnoreCase(message)) {
                            connectionIsAlive = false;
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

                    if ("/end".equalsIgnoreCase(clientMessage)) {
                        System.out.println("closeConnection");
                        connectionIsAlive = false;
                        closeConnection();

                    }
                } while (connectionIsAlive);
            }
        };

        threadWriter.setDaemon(true);
        return threadWriter;
    }

    private void printToConsole(String message) {
        System.out.printf("[client] <- %s \n", message);
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
