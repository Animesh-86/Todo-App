package com.example.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<Todo> todos;
    static { // initializing todo
        todos.add(new Todo(1, "Animesh", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "Animesh", "Learn Spring", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "Animesh", "Learn Spring MVC", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
