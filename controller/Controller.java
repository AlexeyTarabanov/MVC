package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

// Этот класс будет получать запрос от клиента, оповещать Модель об этом,
// а Модель, в свою очередь, будет обновлять ModelData.
public class Controller {

// Controller знает о Model, но не знает о внутреннем устройстве конкретной Model (к которой обращается)
// Controller взаимодействует с конкретной реализацией Model-и посредством (абстрактного) интерфейса Model

    private Model model;
    // отображать список пользователей
    private UsersView usersView;
    // редактировать пользователя
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    // загружаем пользователей
    public void onShowAllUsers() {
        model.loadUsers();
        // обновление данных
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id) {
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

}
