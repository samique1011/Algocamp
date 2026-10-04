package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Schema.Todo;
import com.example.demo.Service.DemoApplicationService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController 
@AllArgsConstructor 
public class DemoApplicationController {
    public DemoApplicationService ds;
    @GetMapping("/todos")
    public List<Todo> getMethodName() {
        return ds.getTodos();
    }
    
}
