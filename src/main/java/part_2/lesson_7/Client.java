package part_2.lesson_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {


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

        connectionIsAlive = true;

//         Thread threadListener = new Thread() {
//            @Override
//            public void run() {
//
//                try {
//                    do {
//                        message = in.readUTF();
//                        System.out.println("[server]-> " + message);
//                    } while (!"/end".equalsIgnoreCase(message));
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    closeConnection();
//                }
//            }
//        };
//
//         threadListener.setDaemon(true);
//         threadListener.start();
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
                    sendMessage(clientMessage);

                    if ("/end".equalsIgnoreCase(clientMessage)) {
                        connectionIsAlive = false;
                        closeConnection();
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
                    do {
                        message = in.readUTF();
                        System.out.println("[server]-> " + message);

                        if ("/end".equalsIgnoreCase(message)) {
                            connectionIsAlive = false;
                            closeConnection();
                        }
                    } while (connectionIsAlive);

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


    public static void main(String[] args) {
        new Client().start();
    }

}
