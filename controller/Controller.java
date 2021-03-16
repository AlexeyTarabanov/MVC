package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;

// Этот класс будет получать запрос от клиента, оповещать Модель об этом,
// а Модель, в свою очередь, будет обновлять ModelData.
public class Controller {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    // загружаем пользователей
    public void onShowAllUsers() {
        model.loadUsers();
    }


}
