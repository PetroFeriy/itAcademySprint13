package com.example.demo.controller;

import com.example.demo.model.ToDo;
import com.example.demo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
@Validated
public class ToDoController implements BaseController<ToDo> {

    private final ToDoService service;

    @GetMapping
    @Override
    public List<ToDo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public ToDo getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Override
    public ToDo create(@Valid @RequestBody ToDo entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
