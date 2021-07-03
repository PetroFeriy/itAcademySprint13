package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
