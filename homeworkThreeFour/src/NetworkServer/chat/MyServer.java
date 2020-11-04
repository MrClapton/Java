package NetworkServer.chat;

import NetworkClientServer.Command;
import NetworkServer.chat.auth.AuthService;
import NetworkServer.chat.auth.BaseAuthService;
import NetworkServer.chat.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyServer {

    private final ServerSocket serverSocket;
    private final List<ClientHandler> clients = new ArrayList<>();
    private final AuthService authService;


    public MyServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.authService = new BaseAuthService();
    }

    public void start() throws IOException {
        System.out.println("Сервер был запущен");

        authService.start();
        try {
            while (!serverSocket.isClosed()) {
                waitAndProcessNewClientConnection();
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            System.err.println("Failed to accept new connection");
            e.printStackTrace();
        } finally {
            authService.stop();
            serverSocket.close();
        }
    }

    private void waitAndProcessNewClientConnection() throws ExecutionException, InterruptedException, IOException {
        ExecutorService clientConnectionService = Executors.newSingleThreadExecutor();
        Future<Boolean> connectionSuccess = clientConnectionService.submit(() -> {

            System.out.println("Ожидание нового подключения....");
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");// /auth login password\
                processClientConnection(clientSocket);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        });

        if (!connectionSuccess.get()) {
            throw new IOException();
        }
    }

    private void processClientConnection(Socket clientSocket) throws IOException {
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized void broadcastMessage(ClientHandler sender, Command command) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }

            client.sendMessage(command);
        }
    }

    public synchronized void subscribe(ClientHandler handler) throws IOException {
        clients.add(handler);
        List<String> users = getAllUsers();
        broadcastMessage(null, Command.updateUsersListCommand(users));
    }

    public synchronized void unsubscribe(ClientHandler handler) throws IOException {
        clients.remove(handler);
        List<String> users = getAllUsers();
        broadcastMessage(null, Command.updateUsersListCommand(users));
    }

    private List<String> getAllUsers() {
        List<String> usernames = new ArrayList<>();
        for (ClientHandler client: clients) {
            usernames.add(client.getUsername());
        }
        return usernames;
    }

    public synchronized boolean isNicknameAlreadyBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void sendPrivateMessage(String recipient, Command command) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(recipient)) {
                client.sendMessage(command);
            }
        }
    }
}