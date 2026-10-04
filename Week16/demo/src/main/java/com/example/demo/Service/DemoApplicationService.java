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

    public DemoApplicationService(@Qualifier("Type-2") iDemoApplicationType de){
        this.de = de;
    }

    public List<Todo> getTodos(){
        return de.getTodos();
    }
}
