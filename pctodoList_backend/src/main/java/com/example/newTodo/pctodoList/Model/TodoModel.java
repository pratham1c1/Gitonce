package com.example.newTodo.pctodoList.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "todo_table")
public class TodoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todo_id;

    private String title;
    private String desc;

    @Column(name = "todo_id_fk")
    private int userId;
//
//    @ManyToOne
//    @EqualsAndHashCode.Exclude
//    @JoinColumn(name = "user_id_fk" , referencedColumnName = "user_id")
//    @JsonIgnoreProperties("todo_list")
//
//    private UserModel userPerson;
}
