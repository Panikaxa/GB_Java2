package lesson6;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader keyboard;

    public Client(){
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendMessage();
    }

    public static void main(String[] args) {
        new Client();
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        System.out.println("We have the connection...");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String inputMsg = in.readUTF();
                    if (inputMsg.equalsIgnoreCase("/end")){
                        System.out.println("Connection is closed");
                        closeConnection();
                        break;
                    }
                    System.out.println("Server: " + inputMsg);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
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

    public void sendMessage(){
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("We are beginning.... Enter something....");
        String outputMsg = "";
        try {
            while (!outputMsg.equalsIgnoreCase("/end")) {
                outputMsg = keyboard.readLine();
                out.writeUTF(outputMsg);
                out.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
