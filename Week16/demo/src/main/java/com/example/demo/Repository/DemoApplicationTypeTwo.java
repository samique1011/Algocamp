package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Schema.Todo;

@Repository("Type-2")
public class DemoApplicationTypeTwo implements iDemoApplicationType{
    public List<Todo> li = new ArrayList<>(List.of(
        new Todo(1, "jehehehe"),
        new Todo(2, "Muehehe")
    ));

    public List<Todo> getTodos(){
        return li;
    }
}
