package com.javarush.task.task36.task3608.model;

public interface Model {

    // Используя любую модель мы сможем получить все необходимые данные для отображения.
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);
}
