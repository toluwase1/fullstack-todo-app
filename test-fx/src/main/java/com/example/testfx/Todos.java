package com.example.testfx;

public class Todos {
    private String taskTitle;
    private String taskDescription;
    private String startDate;
    private String finishDate;

    public Todos(String taskTitle, String taskDescription, String startDate, String finishDate) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }
}
