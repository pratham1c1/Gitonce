package com.example.newTodo.pctodoList.Repository;

import com.example.newTodo.pctodoList.Model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepo extends JpaRepository<TodoModel , Integer> {
}
