package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Validated
public class UserController implements BaseController<User> {

    private final UserService service;

    @GetMapping
    @Override
    public List<User> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    @Override
    public User getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Override
    public User create(@Valid @RequestBody User entity) {
        return service.create(entity);
    }

    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
