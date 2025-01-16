package com.todo_list.demo.service;

import com.todo_list.demo.dto.Todo;
import com.todo_list.demo.mapper.TodolistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodolistService {

    private final TodolistMapper todolistMapper;

    //todo-list 조회
    public List<Todo> getTos(){

        return todolistMapper.getTodos();
    }

    //todo 생성
    public Todo createTodo(Todo todo){
      //int createdTodoId =  todolistMapper.createTodo(todo);
        todolistMapper.createTodo(todo);

       return findById(todo.getId());
    }

    //상태 변경
    public int updateTodo(Long id ,Todo todo){
        todo.setId(id);
        return todolistMapper.updateTodo(todo);
    }

    //id로 todo 가져오기
    public Todo findById(Long id){
        return todolistMapper.findById(id);
    }

    public void deleteTodo(Long id){
        todolistMapper.deleteTodo(id);
    }
}

