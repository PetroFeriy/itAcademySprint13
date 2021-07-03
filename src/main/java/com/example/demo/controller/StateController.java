package com.example.demo.controller;

import com.example.demo.model.State;
import com.example.demo.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/state")
@RequiredArgsConstructor
@Validated
public class StateController implements BaseController<State> {

    private final StateService stateService;

    @Override
    @GetMapping
    public List<State> getAll() {
        return stateService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public State getById(@PathVariable("id") Long id) {
        return stateService.findById(id);
    }

    @Override
    @PostMapping
    public State create(@Valid @RequestBody State entity) {
        return stateService.create(entity);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        stateService.delete(id);
    }
}
