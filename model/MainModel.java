package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

// Model не знает о Controller и View (как следствие - отсутствие в ней ссылок на них)
// Model-и для работы не нужны ни Controller ни View.
public class MainModel implements Model{

    private ModelData modelData = new ModelData();
    // с помощью этого поля будем обращаться к сервисам
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        // получем всех пользователей между 1 и 100 уровнями и кладем их в modelData
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }
}
