package com.example.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService() {
        return todoService;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findByUsername("Animesh");
        model.addAttribute("todos", todos);
        return "listTodos";   // file name of jsp
    }

//    @RequestMapping(value="add-todo", method = RequestMethod.GET)
//    public String showTodoPage(){
//        //List<Todo> todos = todoService.findByUsername("Animesh");
//        //model.addAttribute("todos", todos);
//        return "Todo";   // file name of jsp
//    }
//
//    @RequestMapping(value="add-todo", method = RequestMethod.POST)
//    public String addNewPage(@RequestParam String description, ModelMap model){
//        String username = (String)model.get("name");
//        todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
//
//        //List<Todo> todos = todoService.findByUsername("Animesh");
//        //model.addAttribute("todos", todos);
//        return "redirect:list-todos";   // file name of jsp
//    }
    //GET, POST
    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, Todo todo) {
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(),
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
