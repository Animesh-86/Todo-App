package com.example.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import jakarta.validation.Valid;
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
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate,boolean done){
            Todo todo = new Todo(++todosCount, username, description, targetDate, done);
            todos.add(todo);
    }
    
    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }



    /**
     * Deletes todos matching the given id from the in-memory list.
     *
     * Explanation:
     * - Creates a Predicate<Todo> that evaluates to true when a todo's getId() equals the provided id.
     * - Calls todos.removeIf(predicate), which iterates the list and removes every element that matches.
     *
     * Notes:
     * - If more than one todo has the same id, all of them will be removed.
     * - The list is modified in place; removeIf returns a boolean indicating whether any element was removed,
     *   but that result is not used here.
     * - This method is not thread-safe; synchronize external access if used concurrently.
     */

//    public Todo findById(int id) {
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        Todo todo = todos.stream().filter(predicate).findFirst().get();
//
//        return todo;
//    }
//
//    public void updateTodo(@Valid Todo todo) {
//        deleteById(todo.getId());
//        todos.add(todo);
//    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();

        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
