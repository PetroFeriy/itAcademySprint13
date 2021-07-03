package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate createdAt;

    @NotEmpty
    private String title;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User ownerUser;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "collaborator_todos",
            joinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;
    @OneToMany(mappedBy = "toDo")
    private List<Task> tasks;
}
