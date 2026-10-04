package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Schema.Todo;

@Repository("Type-1") 
public class DemoApplicationTypeOne implements iDemoApplicationType {
    public List<Todo> li = new ArrayList<>(List.of(
        new Todo(1, "Go shopping"),
        new Todo(2, "Learn Spring Boot"),
        new Todo(3, "Complete Todo App")
    ));

    public List<Todo> getTodos(){
        return li;
    }
}
