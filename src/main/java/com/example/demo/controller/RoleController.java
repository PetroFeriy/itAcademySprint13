package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
@RequiredArgsConstructor
@Validated
public class RoleController implements BaseController<Role> {

    private final RoleService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }

    @PostMapping
    public Role create(@Valid @RequestBody Role entity) {
        return roleService.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        roleService.delete(id);
    }

}
