package server;

import domain.User;
import handler.ProcessClientRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    private ServerSocket serverSocket;
    List<ProcessClientRequest> activeExperts;

    public Server() throws IOException {
        serverSocket = new ServerSocket(9000);
        activeExperts = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Cekanje klijenta...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao.");
                handleClient(socket);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        cancelClients();
    }

    private void handleClient(Socket socket) {
        ProcessClientRequest processClientRequest = new ProcessClientRequest(socket);
        activeExperts.add(processClientRequest);
        processClientRequest.start();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<User> getActiveAdministrators() {
        List<User> users = new ArrayList<>();
        for (ProcessClientRequest c : activeExperts) {
            users.add(c.getActiveExpert());
        }
        return users;
    }

    private void cancelClients() {
        for (ProcessClientRequest k : activeExperts) {
            try {
                k.getSocket().close();
                activeExperts.remove(k);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
