package lesson7.client;

import lesson7.server.MyServer;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader keyboard;
    private String login;
    private String pass;

    public Client(String login, String pass) {
        this.login = login;
        this.pass = pass;
        openConnection();
        sendMessage();
    }

    private void openConnection(){
        try {
            socket = new Socket(SERVER_ADDR, MyServer.PORT);
            System.out.println("We have the connection...");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            onAuthClick(login, pass);
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.startsWith("/authok")) {
                            System.out.println("Authorization is ok");
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            System.out.println("Connection is closed");
                            closeConnection();
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
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

    private void sendMessage(){
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


    private void onAuthClick(String login, String pass) {
        try {
            out.writeUTF("/auth " + login + " " + pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
