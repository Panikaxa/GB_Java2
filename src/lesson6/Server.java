package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int SERVER_PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader keyboard;
    private String inputMsg = "";

    public Server(){
        openConnection();
        sendMessage();
    }

    public static void main(String[] args) {
        new Server();
    }

    public void openConnection() {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("We are waiting a new client");
            socket = serverSocket.accept();
            System.out.println("We have a new client");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        inputMsg = in.readUTF();
                        if (inputMsg.equalsIgnoreCase("/end")) {
                            out.writeUTF(inputMsg);
                            out.flush();
                            System.out.println("Client is disconnected. Enter any character to close connection");
                            break;
                        }
                        System.out.println("Client: " + inputMsg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("We are beginning.... Enter something....");
        try {
            while (true) {
                if (inputMsg.equalsIgnoreCase("/end")){
                    closeConnection();
                    System.out.println("Connection is closed");
                    break;
                }
                String outputMsg = keyboard.readLine();
                out.writeUTF(outputMsg);
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            keyboard.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
