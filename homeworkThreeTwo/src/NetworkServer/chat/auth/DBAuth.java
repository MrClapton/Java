package NetworkServer.chat.auth;

import NetworkServer.chat.services.UserServices;

public class DBAuth implements AuthService {
    @Override
    public void start() {
        System.out.println("Auth service has been started");
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        return UserServices.getUsernameByLoginAndPassword(login, password);
    }

    @Override
    public void stop() {
        System.out.println("Auth service has been finished");
    }
}
