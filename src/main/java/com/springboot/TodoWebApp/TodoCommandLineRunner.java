package com.springboot.TodoWebApp;


import com.springboot.TodoWebApp.todo.Todo;
import com.springboot.TodoWebApp.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TodoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private TodoRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new Todo("bego", "Learn Android Development",
                LocalDate.now().plusYears(1), "false"));
        repository.save(new Todo("bego", "Learn Flutter Development",
                LocalDate.now().plusYears(2), "false"));
        repository.save(new Todo("bego", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), "false"));
    }
}
