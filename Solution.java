package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.Model;
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
 https://cdn.javarush.ru/images/comment/4404c204-34ef-46bf-9d16-100801a43711/original.jpeg
 3. В классе Controller:
 - добавил поле UsersView usersView и сеттер для него
 - в методе onShowAllUsers после загрузки прользователей, добавил обновленные данные во usersView (refresh)


 */

public class Solution {
    public static void main(String[] args) {
        Model model = new FakeModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
    }
}