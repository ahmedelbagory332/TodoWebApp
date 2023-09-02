package com.springboot.TodoWebApp.todo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> getTodos() {
        return repository.findAll();
    }
    public void addTodo(String username, String description, LocalDate targetDate, String done) {
        repository.save(new Todo(username,description,targetDate,done));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Todo getById(Long id) {
        return repository.findById(id).orElse(new Todo());
    }

    public void updateTodo( Todo todo) {
        repository.save(todo);

    }
}