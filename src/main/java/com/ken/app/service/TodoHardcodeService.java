package com.ken.app.service;

import com.ken.app.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodeService {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Ken", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "Katie", "Learn Coding Language", new Date(), false));
        todos.add(new Todo(++idCounter, "ken", "Learn Game Development", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if(todo == null){
            return null;
        }
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    private Todo findById(long id) {
        for(Todo todo: todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

}
