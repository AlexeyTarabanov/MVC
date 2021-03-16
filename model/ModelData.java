package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

// ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
public class ModelData {

    // список пользователей для отображения
    private List<User> users;
    // будет хранить в себе конкретного пользователя
    private User activeUser;
    // будет хранить булево значение удалены ли пользователи
    private boolean displayDeletedUserList;

    public List<User> getUsers() {
        return users;
    }

    public User getActiveUser() { return activeUser; }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setActiveUser(User activeUser) { this.activeUser = activeUser; }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}
