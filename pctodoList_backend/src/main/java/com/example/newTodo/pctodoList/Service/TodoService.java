package com.example.newTodo.pctodoList.Service;


import com.example.newTodo.pctodoList.Model.TodoModel;
import com.example.newTodo.pctodoList.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;


//     Add

    public TodoModel add_todo(TodoModel obj){
        repo.save(obj);
        return obj;
    }


    // Display

    public List<TodoModel> display_todo(){
        return repo.findAll();
    }

    // Delete

    public void delete_todo(int id){
        repo.deleteById(id);
    }


    // Update

    public TodoModel update_todo(TodoModel obj){
        TodoModel new_obj = repo.findById(obj.getTodo_id()).orElse(null);
        new_obj.setTitle(obj.getTitle());
        new_obj.setDesc(obj.getDesc());
        repo.save(new_obj);
        return new_obj;
    }
}
