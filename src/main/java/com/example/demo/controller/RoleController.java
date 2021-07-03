package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
@RequiredArgsConstructor
public class RoleController {

//    private final RoleService roleService;

    private final List<Role> roles = List.of(
            Role.builder()
                    .id(1L)
                    .name("Admin")
                    .build(),
            Role.builder()
                    .id(2L)
                    .name("Test")
                    .build(),
            Role.builder()
                    .id(3L)
                    .name("User")
                    .build()
    );

    @GetMapping
    public List<Role> getAll(){
//        return roleService.findAll();
        return roles;
    }
}
