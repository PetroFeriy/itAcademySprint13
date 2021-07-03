package com.example.demo.service;

import com.example.demo.DAO.ToDoRepository;
import com.example.demo.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ToDoService implements BaseService<ToDo> {

    private final ToDoRepository toDoRepository;

    @Override
    public ToDo create(ToDo entity) {
        return toDoRepository.save(entity);
    }

    @Override
    public ToDo findById(Long id) {
        return toDoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<ToDo> findAll() {
        List<ToDo> todos = new ArrayList<>();
        toDoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}
