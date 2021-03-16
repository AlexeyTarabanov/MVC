package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

// Он будет отображать список пользователей в консоль.
public class UsersView implements View{

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
        for (User user : modelData.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");
    }

    // запуск события - показать всех пользователей
    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    // запуск события - показать удаленных пользователей
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
