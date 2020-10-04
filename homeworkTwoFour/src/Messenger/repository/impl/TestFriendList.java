package Messenger.repository.impl;

import Messenger.model.Friend;
import Messenger.repository.FriendList;

import java.util.List;

public class TestFriendList implements FriendList {

    @Override
    public List<Friend> getAllData() {
        return List.of (
                new Friend("Alex", "Petrov"),
                new Friend("Masha", "Mironova")
        );
    }
}
