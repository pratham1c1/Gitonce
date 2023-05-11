package com.example.newTodo.pctodoList.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor


//@Table(name = "user_table")
//@Entity
@javax.persistence.Table(name = "user_table")
@javax.persistence.Entity(name = "user_table")
public class UserModel implements Serializable {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "name")
    private String name ;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @JsonIgnoreProperties("userId")

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name = "todo_id_fk", referencedColumnName = "user_id")
    private List<TodoModel> todo_list;
}
