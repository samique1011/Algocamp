package com.example.demo.Repository;

import java.util.List;

import com.example.demo.Schema.Todo;

public interface iDemoApplicationType {
    public List<Todo> getTodos();
    public String addTodo(int id , String desc);
    public String updateTodo(int id , String newDesc);
    public String deleteTodo(int id);
}

