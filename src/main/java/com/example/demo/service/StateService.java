package com.example.demo.service;

import com.example.demo.DAO.StateRepository;
import com.example.demo.model.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class StateService implements BaseService<State> {

    private final StateRepository stateRepository;

    @Override
    public State create(State state) {
        return stateRepository.save(state);
    }

    @Override
    public State findById(Long id) {
        return stateRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<State> findAll() {
        List<State> states = new ArrayList<>();
        stateRepository.findAll().forEach(states::add);
        return states;
    }

    @Override
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
