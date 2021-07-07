package com.toluwase.appbackend.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TodosRequest {
    private String taskTitle;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Users users;
}
