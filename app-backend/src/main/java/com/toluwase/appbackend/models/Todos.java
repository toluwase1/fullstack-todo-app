package com.toluwase.appbackend.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Todos extends BaseModel{

    @Column(name = "task")
    @NotNull
    @Size(min = 5, max = 50)
    private String task;

    @Column(name = "description")
    @NotNull
    @Size(min = 5, max = 250)
    private String description;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

//    @Column(name = ("priority"))
//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private Priority priority;

    @ManyToOne
    private Users users;

    public Todos() {
    }
}
