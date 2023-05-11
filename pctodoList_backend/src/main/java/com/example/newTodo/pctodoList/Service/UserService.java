package com.example.newTodo.pctodoList.Service;


import com.example.newTodo.pctodoList.Model.TodoModel;
import com.example.newTodo.pctodoList.Model.UserModel;
import com.example.newTodo.pctodoList.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    //Add User
    public UserModel add_user(UserModel obj){
        repo.save(obj);
        return obj;
    }

    //Display User
    public List<UserModel> display_user(){
        return repo.findAll();
    }


    public UserModel display_single_user(UserModel obj){
        return repo.find_single_user(obj.getUsername() , obj.getPassword());
    }

    public List<TodoModel> display_all_todos(UserModel obj){
        return repo.get_all_todos(obj.getUsername() , obj.getPassword());
    }

    public List display_all(){
        return repo.find_all_user();
    }


    //Delete User By Id

    public void delete_user(int id){
        repo.deleteById(id);
    }

    // Update User By Object
    public UserModel update_user(UserModel obj){
        UserModel new_ob = repo.findById(obj.getUser_id()).orElse(null);
        new_ob.setName(obj.getName());
        new_ob.setUsername(obj.getUsername());
        new_ob.setPassword(obj.getPassword());
        repo.save(new_ob);
        return new_ob;
    }
}
