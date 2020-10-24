package NetworkClient.controllers;

import NetworkClient.NetworkChatClient;
import NetworkClient.models.Network;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthDialogController {
    @FXML
    public TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;

    private Network network;
    private NetworkChatClient clientApp;

    @FXML
    public void executeAuth(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            NetworkChatClient.showNetworkError("Username and password should be not empty!", "Auth error");
            return;
        }

        network.sendAuthCommand(login, password);
    }

    public void authOk() {
        Platform.runLater(() -> clientApp.openChat());

    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setClientApp(NetworkChatClient clientApp) {
        this.clientApp = clientApp;
    }

    public Button getAuthButton() {
        return authButton;
    }

    public void setAuthButton(Button authButton) {
        this.authButton = authButton;
    }
}
