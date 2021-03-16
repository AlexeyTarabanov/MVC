package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 Паттерн проектирования MVC
 https://cdn.javarush.ru/images/comment/cfc391b7-ecec-46fe-be20-f99b022b2546/original.jpeg

 Шаг 1.
 1. Создал пакет model, в котором создал класс ModelData.
 (ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте)
 В классе:
 - создал поле ModelData modelData и проинициализировал его
 - реализовал метод loadUsers()

 Шаг 2.
 1. Создал пакет controller, в котором создал класс Controller
 (Этот класс будет получать запрос от клиента, оповещать Модель об этом, а та, в свою очередь, будет обновлять ModelData..)
 В интерфейсе View создал методы:
 - refresh(ModelData modelData);
 - setController(Controller controller);

 Шаг 3.
 1. В пакете view:
 - создал класс UsersView, реализующий View.
 (Он будет отображать список пользователей в консоль)
 2. В классе UsersView:
 - добавил поле Controller controller вместе с сеттером
 - реализовал метод refresh()
 - создал и реализовал метод fireEventShowAllUsers(), который будет эмулировать событие клиента
 3. В классе Controller:
 - добавил поле UsersView usersView и сеттер для него
 - в методе onShowAllUsers после загрузки прользователей, добавил обновленные данные во usersView (refresh)

 https://cdn.javarush.ru/images/comment/4404c204-34ef-46bf-9d16-100801a43711/original.jpeg

 Шаг 4.
 1. В пакете model:
 - создал класс MainModel (аналогичный FakeModel но данные он уже будет получать из DataSource)
 - так как Модель обращается к сервисам, то добавил поле UserService userService и проинициализировал его объектом
 - реализовал методы getModelData() и loadUsers()
 2. В классе Solution заменил FakeModel на MainModel

 Шаг 5.
 1. Создал и реализовал методы:
 - в классе UsersView - fireEventShowDeletedUsers(),
 - в классе Controller - onShowAllDeletedUsers(),
 - в итерфейсе Model - loadDeletedUsers()
 (реализовал его в классах MainModel и FakeModel)
 2. В классе Solution вызвал метод fireEventShowDeletedUsers

 Шаг 6.
 1. В классе ModelData:
 - создал поле User activeUser, геттер и сеттер для него
 (будет хранить в себе конкретного пользователя)
 2. В пакете view:
 - создал класс EditUserView, реализующий View.
 (он будет отображать данные о редактировании конкретного пользователя)
 - реализовал метод refresh()
 3. В классе Controller:
 - создал поле EditUserView editUserView и сеттер для него
 4. В классе ModelData:
 - создал поле boolean displayDeletedUserList(), геттер и сеттер для него
 (будет хранить булево значение удалены ли пользователи)
 5. В классе UsersView:
 - изменил метод refresh
 (так, чтобы он отображал "All users:" либо "All deleted users:" в зависимости от того, какие пользователи находятся в списке)
 6. В классе MainModel:
 - добавил в методы loadUsers() и loadDeletedUsers() вызов метода-флага setDisplayDeletedUserList
 (тем самым помечая какие ползователи находятся в списке)

 Шаг 7.
 1. Создал и реализовал методы:
 - в классе UsersView - fireEventOpenUserEditForm(long id),
 - в классе Controller - onOpenUserEditForm(long userId),
 - в итерфейсе Model - loadUserById(long userId)
 (реализовал его в классах MainModel и FakeModel)
 2. В классе Solution:
 - создал объект editUserView, передал его controller
 - установил controller для editUserView
 - вызвал метод fireEventShowDeletedUsers

 Шаг 8.
 1. Создал и реализовал методы:
 - в классе EditUserView - fireEventUserDeleted(long id),
 - в классе Controller - onUserDelete(long id),
 - в итерфейсе Model - deleteUserById(long id)
 (реализовал его в классах MainModel и FakeModel)
 2. В классе Solution:
 - вызвал метод fireEventShowDeletedUsers
 3. В классе MainModel:
 - реализовал метод getAllUsers()
 - исправил метод loadUsers()
 */

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        // запуск события - показать всех пользователей
        usersView.fireEventShowAllUsers();
        // запуск события - открыть форму редактирования пользователя
        usersView.fireEventOpenUserEditForm(126);
        // запуск события - удалить User-a
        editUserView.fireEventUserDeleted(124L);
        // запуск события - показать удаленных пользователей
        usersView.fireEventShowDeletedUsers();
    }
}