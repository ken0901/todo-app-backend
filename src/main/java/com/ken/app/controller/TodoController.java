package com.ken.app.controller;

import com.ken.app.entity.Todo;
import com.ken.app.service.TodoHardcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TodoController {

    @Autowired
    private TodoHardcodeService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return this.todoService.findAll();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
