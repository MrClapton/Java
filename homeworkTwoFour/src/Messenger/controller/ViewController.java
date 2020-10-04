package Messenger.controller;

import Messenger.Main;
import Messenger.model.Friend;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class ViewController {

    @FXML
    private TableView<Friend> friendTable;
    @FXML
    private TableColumn<Friend, String> firstNameColumn;
    @FXML
    private TableColumn<Friend, String> lastNameColumn;
    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    private Main mainApp;

    @FXML
    public void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

   public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        friendTable.setItems(mainApp.getFriendData());

        sendButton.setOnAction(event -> {
            chatHistory.setText(textField.getText());
        });

        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {//.getCode().getName().equals("\\u2386")) {
                    chatHistory.setText(textField.getText());
                }
            }
        });
    }

}
