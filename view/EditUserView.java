package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

// будет отображать данные о редактировании конкретного пользователя
public class EditUserView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        // Пользователь, подлежащий редактированию:
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println( "===================================================");
    }

    // запуск события - удалить User-a
    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }
}
