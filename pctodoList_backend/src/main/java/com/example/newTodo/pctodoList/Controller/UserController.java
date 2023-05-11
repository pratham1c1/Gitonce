package com.example.newTodo.pctodoList.Controller;


import com.example.newTodo.pctodoList.Model.TodoModel;
import com.example.newTodo.pctodoList.Model.UserModel;
import com.example.newTodo.pctodoList.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService serv;

    //Add User
    @PostMapping("/userAdd")
    public UserModel user_add(@RequestBody UserModel obj){
        serv.add_user(obj);
        return obj;
    }

    // Display User
    @GetMapping("/userDisplay")
    public List<UserModel> user_display(){
        return serv.display_user();
    }


    @PostMapping("/one")
    public UserModel single_user_display(@RequestBody UserModel obj) {
        return serv.display_single_user(obj);
    }

    @PostMapping("/getalltodos")
    public List<TodoModel> all_todos_display(@RequestBody UserModel obj){
        return serv.display_all_todos(obj);
    }

    @GetMapping("/all")
    public List all_display(){
        return serv.display_all();
    }


    // Delete User
    @DeleteMapping("/userDelete")
    public String user_delete(@PathVariable int id){
        serv.delete_user(id);
        return "The record with id : "+ id + " is deleted";
    }


    // Update User
    @PutMapping("/userUpdate")
    public UserModel user_update(@RequestBody UserModel obj){
        return serv.update_user(obj);
    }

}
