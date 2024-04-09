package com.app.todo.service;

import com.app.todo.model.Todo;
import com.app.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;

    public Optional<Todo> findTodoById(Long id) {
        return todoRepo.findById(id);
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @Transactional
    public Todo saveTodo(Todo todo) {
        return todoRepo.save(todo);
    }

    @Transactional
    public void deleteTodo(Todo todo) {
        todoRepo.delete(todo);
    }
}
