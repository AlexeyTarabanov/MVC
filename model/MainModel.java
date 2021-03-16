package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

// Model не знает о Controller и View (как следствие - отсутствие в ней ссылок на них)
// Model-и для работы не нужны ни Controller ни View.
public class MainModel implements Model{

    private ModelData modelData = new ModelData();
    // с помощью этого поля будем обращаться к сервисам
    private UserService userService = new UserServiceImpl();

    // эти методы возвращают данные
    // Controller вызывает эти методы и получает запрашиваемые данные
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }

    // эти методы работают с UserService
    // (который в свою очередь работает с DAO, которая в свою очередь работает с данными)
    // Controller вызывает эти методы, тем самым "просит" Model
    // сформатировать нужные данные и "упаковать" их в объект класса ModelData
    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        // получем всех пользователей между 1 и 100 уровнями и кладем их в modelData
        //modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        loadUsers();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        loadUsers();
    }
}
