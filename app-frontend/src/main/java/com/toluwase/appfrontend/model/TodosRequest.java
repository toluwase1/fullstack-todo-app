package com.toluwase.appfrontend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TodosRequest {
    private String taskTitle;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private Users users;


}
