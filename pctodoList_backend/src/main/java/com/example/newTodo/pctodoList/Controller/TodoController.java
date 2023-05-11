package com.example.newTodo.pctodoList.Controller;


import com.example.newTodo.pctodoList.Model.TodoModel;
import com.example.newTodo.pctodoList.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService serv;


    //Add a_todo

    @PostMapping("/todoAdd")

    public TodoModel todo_add(@RequestBody TodoModel obj){
        serv.add_todo(obj);
        return obj;
    }


    // Display todos

    @GetMapping("/todoDisplay")

    public List<TodoModel> todo_display(){
        return serv.display_todo();
    }


    // Delete todos

    @DeleteMapping("/todoDelete/{id}")

    public String todo_delete(@PathVariable int id){
        serv.delete_todo(id);
        return "The record with id : " + id + " is deleted";
    }


    // Update todos

    @PutMapping("/todoUpdate")

    public TodoModel todo_update(@RequestBody TodoModel obj){
       return serv.update_todo(obj);
    }
}
