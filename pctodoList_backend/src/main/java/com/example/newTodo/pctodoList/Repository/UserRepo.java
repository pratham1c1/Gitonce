package com.example.newTodo.pctodoList.Repository;

import com.example.newTodo.pctodoList.Model.TodoModel;
import com.example.newTodo.pctodoList.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

    @Query("SELECT u FROM user_table u WHERE u.username =?1 and u.password=?2")
    public UserModel find_single_user(String username , String password);


    @Query("Select u.todo_list from user_table u where u.username=?1 and u.password=?2")
    public List<TodoModel> get_all_todos(String username , String password);


    @Query("SELECT u.todo_list FROM user_table u WHERE u.username='pry'")
    public List find_all_user();
}
