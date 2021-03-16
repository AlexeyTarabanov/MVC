package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

// ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
public class ModelData {

    // список пользователей для отображения
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
