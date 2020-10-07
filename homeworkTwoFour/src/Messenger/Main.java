package Messenger;

import Messenger.controller.ViewController;
import Messenger.model.Friend;
import Messenger.repository.FriendList;
import Messenger.repository.impl.TestFriendList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private final FriendList friendList;
    private final ObservableList<Friend> friendData;

    public Main() {
        this.friendList = new TestFriendList();
        this.friendData = FXCollections.observableArrayList(friendList.getAllData());
    }

    public ObservableList<Friend> getFriendData() {
        return friendData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/view.fxml"));

        Parent root = loader.load();//FXMLLoader.load(getClass().getResource("view/view.fxml"));

        ViewController controller = loader.getController();
        controller.setMainApp(this);

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
