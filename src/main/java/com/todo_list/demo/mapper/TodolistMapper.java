package com.todo_list.demo.mapper;

import com.todo_list.demo.dto.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodolistMapper {

    //todo 조회하기
    List<Todo> getTodos();

    //todo 넣기
    int createTodo(Todo todo);

    //id로 todo조회
    Todo findById(Long id);

    //todo 상태변경
    int updateTodo(Todo todo);

    //todo 삭제
    void deleteTodo(Long id);
}
