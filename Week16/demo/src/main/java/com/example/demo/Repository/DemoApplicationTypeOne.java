package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.Schema.Todo;

@Repository 
@Profile("dev")
public class DemoApplicationTypeOne implements iDemoApplicationType {
    public List<Todo> li = new ArrayList<>(List.of(
        new Todo(1, "Go shopping"),
        new Todo(2, "Learn Spring Boot"),
        new Todo(3, "Complete Todo App")
    ));

    public List<Todo> getTodos(){
        return li;
    }
    public String addTodo(int id , String desc){
        li.add(new Todo(id , desc));
        return "Todo Added";
    }

    public String updateTodo(int id , String newDesc){
        for(int i = 0; i < li.size(); i++){
            if(li.get(i).id == id){
                li.set(i , new Todo(id , newDesc));
            }
        }
        return "Todo Updated";
    }

    public String deleteTodo(int id){
        int idx = -1;
        for(int i = 0; i < li.size(); i++){
            if(li.get(i).id == id){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            return "No such todo exists";
        }
        else{
            li.remove(idx);
            return "Todo Deleted";
        }
    }
}
