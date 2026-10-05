package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Schema.Todo;
import com.example.demo.Schema.TodoUpdateBody;
import com.example.demo.Service.DemoApplicationService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController 
@AllArgsConstructor 
public class DemoApplicationController {
    public DemoApplicationService ds;
    @GetMapping("/todos")
    public List<Todo> getMethodName() {
        return ds.getTodos();
    }

    @PostMapping("/todos")
    public String postMethodName(@RequestBody Todo todo) {
        return ds.addTodo(todo.id, todo.description);
    }

    @PutMapping("/todos/{id}")
    public String putMethodName(@PathVariable int id , @RequestBody TodoUpdateBody todo){
        return ds.updateTodo(id, todo.description);
    }
    
    @DeleteMapping("/todos/{id}")
    public String deleteMethodName(@PathVariable int id){
        return ds.deleteTodo(id);
    }
    
}
