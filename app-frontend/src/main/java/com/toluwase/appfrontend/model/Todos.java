package com.toluwase.appfrontend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todos {

    private String taskTitle;
    private String description;
    private String startDate;
    private String finishDate;
    private Users users;
}
