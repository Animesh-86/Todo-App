package com.example.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    public TodoService() {
//        todos.add(new Todo(1, "Animesh", "Learn AWS", LocalDate.now().plusYears(1), false));
//        todos.add(new Todo(2, "Animesh", "Learn Spring", LocalDate.now().plusYears(2), false));
//        todos.add(new Todo(3, "Animesh", "Learn Spring MVC", LocalDate.now().plusYears(3), false));
          todos.add(new Todo(++todosCount, "Animesh", "Learn AWS", LocalDate.now().plusYears(1), false));
          todos.add(new Todo(++todosCount, "Animesh", "Learn Spring", LocalDate.now().plusYears(2), false));
          todos.add(new Todo(++todosCount, "Animesh", "Learn Spring MVC", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate,boolean done){
            Todo todo = new Todo(++todosCount, username, description, targetDate, done);
            todos.add(todo);
    }
}
