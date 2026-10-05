package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.iDemoApplicationType;
import com.example.demo.Schema.Todo;

import lombok.AllArgsConstructor;

@Service 
public class DemoApplicationService {
    public iDemoApplicationType de;

    public DemoApplicationService(iDemoApplicationType de){
        this.de = de;
    }

    public List<Todo> getTodos(){
        return de.getTodos();
    }

    public String addTodo(int id , String desc){
        return de.addTodo(id, desc);
    }

    public String updateTodo(int id , String desc){
        return de.updateTodo(id , desc);
    }
    public String deleteTodo(int id){
        return de.deleteTodo(id);
    }
}
