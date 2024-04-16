package co.edu.escuelaing.cvds.lab7.model;

import lombok.Getter;
import lombok.Setter;

public class ToDoItem {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer userId;
    @Setter
    @Getter
    private String title;
    private Boolean completed;

    public ToDoItem() {
    }

    public ToDoItem(Integer id, Integer userId, String title, Boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public boolean getCompleted(){
        return completed;
    }
}
