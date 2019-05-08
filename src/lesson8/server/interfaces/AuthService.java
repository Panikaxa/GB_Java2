package lesson8.server.interfaces;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
