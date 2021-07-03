package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
@RequiredArgsConstructor
@Validated
public class TaskController implements BaseController<Task> {

    private final TaskService service;

    @Override
    @GetMapping
    public List<Task> getAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public Task create(@Valid @RequestBody Task entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
