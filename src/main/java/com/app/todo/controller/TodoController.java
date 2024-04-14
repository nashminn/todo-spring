package com.app.todo.controller;

import com.app.todo.dto.CreateTodoDTO;
import com.app.todo.dto.UpdateTodoDTO;
import com.app.todo.model.Todo;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller()
@RequestMapping(value = "/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public String getTodoById(@PathVariable("id") Long id, Model model) {
        Optional<Todo> optionalTodo = todoService.findTodoById(id);

        if(optionalTodo.isEmpty()) {
            return "Error: Todo not found";
        }

        Todo todo = optionalTodo.get();
        model.addAttribute("todo", todo);
//        return "details";
        return "todoList";
    }

    @GetMapping
    public String getAllTodos(Model model) {
        List<Todo> todoList = todoService.getAllTodos();
        model.addAttribute("todos", todoList);
        return "todoList"; // returns the name of Thymeleaf template
    }

    @PostMapping
    public String createTodo(@ModelAttribute CreateTodoDTO createTodoDTO) {
        System.out.println(createTodoDTO.getTitle() + createTodoDTO.getDescription() + createTodoDTO.getPriority()  + createTodoDTO.getDueDate().toString());
        Todo newTodo = new Todo(createTodoDTO.getTitle(), createTodoDTO.getDescription(), createTodoDTO.getPriority(), false, createTodoDTO.getDueDate());
        todoService.saveTodo(newTodo);
        return "redirect:/todos";
    }

    @PostMapping("/update/{id}")
    public String updateTodoById(@PathVariable("id") Long id, @ModelAttribute UpdateTodoDTO updateTodoDTO) {
        Optional<Todo> optionalTodo = todoService.findTodoById(id);
        if (optionalTodo.isEmpty()) {
            return "error";
        }
        Todo todo = optionalTodo.get();

        todo.setTitle(updateTodoDTO.getTitle());
        todo.setDescription(updateTodoDTO.getDescription());
        todo.setPriority(updateTodoDTO.getPriority());
        todo.setCompleted(updateTodoDTO.getCompleted());
        todo.setDueDate(updateTodoDTO.getDueDate());

        todoService.saveTodo(todo);

        return "redirect:/todos";
    }

//    @DeleteMapping("/{id}")
//    public String deleteTodoById(@PathVariable("id") Long id) {
//        Optional<Todo> optionalTodo = todoService.findTodoById(id);
//
//        if(optionalTodo.isEmpty()) {
//            return "Error: Todo not found for deletion";
//        }
//
//        Todo todo = optionalTodo.get();
//
//        todoService.deleteTodo(todo);
//        return "redirect:/todos";
//    }

    @PostMapping("/delete/{id}")
    public String deleteTodoById(@PathVariable("id") Long id) {
        Optional<Todo> optionalTodo = todoService.findTodoById(id);

        if(optionalTodo.isEmpty()) {
            return "Error: Todo not found for deletion";
        }

        Todo todo = optionalTodo.get();

        todoService.deleteTodo(todo);
        return "redirect:/todos";
    }
}
