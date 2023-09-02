package com.springboot.TodoWebApp.todo;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("api/todoApp/")
@Controller
// SessionAttributes to hold the value which stored in key (name) to transfer to another page
// we write SessionAttributes on page where we want to take value and in page where we want to display the value
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("todos")
    public String getTodos(ModelMap model) {
        List<Todo> todos = todoService.getTodos();
        model.addAttribute("todos", todos);
        return "todoList";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String addNewTodo(ModelMap model) {
        String username = (String)model.get("name");
        // first initialization to avoid null exception
        Todo todo = new Todo(0L, username, "", LocalDate.now(), "false");
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value ="add-todo",method = RequestMethod.POST)
    public String showAddedNewTodo(ModelMap model , @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "addTodo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(),
                todo.getTargetDate(), "false");

        // redirect:todos it call getTodos why ?
        // because we use redirect:{name of path} in this case the path is todos
        return "redirect:todos";
    }


    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String upDateTodo(@RequestParam Long id,ModelMap model) {
       Todo selectedTodo = todoService.getById(id);
        Todo todo = new Todo(selectedTodo.getId(), selectedTodo.getUsername(), selectedTodo.getDescription(), selectedTodo.getTargetDate(), selectedTodo.getDone());
        model.put("todo", todo);
        return "upDateTodo";
    }

    @RequestMapping(value ="update-todo",method = RequestMethod.POST)
    public String showUpdatedTodos( @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "upDateTodo";
        }
        todoService.updateTodo(todo);

        // redirect:todos it call getTodos why ?
        // because we use redirect:{name of path} in this case the path is todos
        return "redirect:todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam Long id) {
        todoService.deleteById(id);
        return "redirect:todos";

    }


}