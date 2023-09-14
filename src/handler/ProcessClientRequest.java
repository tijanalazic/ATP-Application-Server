package handler;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.User;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.login.Login;
import repository.DBRepository;

public class ProcessClientRequest extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    User activeExpert=null;

    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (true) {
            try {
                request = (Request) receiver.receive();
                System.out.println(request.getObject());
                System.out.println(request.getOperation());
                response = new Response();
                switch (request.getOperation()) {
                    case LOGIN -> {
                        User user = (User) request.getObject();
                        response.setResult(Controller.getInstance().login(user));
                        activeExpert = (User) response.getResult();
                    }
                    case CREATE ->
                        response.setResult(Controller.getInstance().create(request.getObject()));
                    case SAVE -> 
                        response.setResult(Controller.getInstance().save(request.getObject()));
                    case DELETE ->
                        response.setResult(Controller.getInstance().delete(request.getObject()));
                    case GET ->
                        response.setResult(Controller.getInstance().get(request.getObject()));
                }
            } catch (Exception e) {
                if (response == null) {
                    System.out.println("Nema odgovora!");
                } else {
                    System.out.println(e.getMessage());
                    response.setException(e);
                }
            }
            try {
                sender.send(response);
                System.out.println(response.getResult());
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public User getActiveExpert() {
        return activeExpert;
    }

    public Socket getSocket() {
        return socket;
    }

}
