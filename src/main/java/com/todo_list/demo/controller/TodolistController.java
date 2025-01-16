package com.todo_list.demo.controller;

import com.todo_list.demo.dto.Todo;
import com.todo_list.demo.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodolistController {

    @Autowired
    TodolistService todolistService;

    @GetMapping("/todos")
    public List getTodos(){
        return todolistService.getTos();
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todolistService.createTodo(todo);
    }


    @PatchMapping("/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id,
                                     @RequestBody Todo todo){
        if(todolistService.updateTodo(id,todo)<1){
            return ResponseEntity.status(404).body("id가 존재하지 않습니다.");
        }
        return ResponseEntity.status(200).body(todolistService.findById(id));
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id){
        todolistService.deleteTodo(id);
    }
}

