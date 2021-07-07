package com.toluwase.appfrontend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todos {

private String taskTitle;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Priority priority;
    private Long userId;
}
